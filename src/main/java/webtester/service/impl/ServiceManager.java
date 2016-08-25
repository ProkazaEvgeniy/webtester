package webtester.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;

import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.RepositoryFactory;
import webtester.repository.RoleRepository;
import webtester.repository.TestRepository;
import webtester.service.AdminService;
import webtester.service.CommonServise;
import webtester.service.TutorService;

public final class ServiceManager {
	private static final String SERVICE_MANADER = "SERVICE_MANADER";

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANADER);
		if (instance == null) {
			instance = new ServiceManager();
			context.setAttribute(SERVICE_MANADER, instance);
		}
		return instance;
	}

	private final AccountRepository accountRepository;
	private final AccountRoleRepository accountRoleRepository;
	private final RoleRepository roleReposotory;
	private final CommonServise commonServise;
	private final AdminService adminService;
	private final BasicDataSource dataSource;
	private final TestRepository testRepository;
	private final TutorService tutorService;

	public CommonServise getCommonServise() {
		return commonServise;
	}

	public AdminService getAdminService() {
		return adminService;
	}
	
	public TutorService getTutorService(){
		return tutorService;
	}

	private ServiceManager() {
		dataSource = buildDataSource();
		accountRepository = RepositoryFactory.createRepository(AccountRepository.class);
		accountRoleRepository = RepositoryFactory.createRepository(AccountRoleRepository.class);
		roleReposotory = RepositoryFactory.createRepository(RoleRepository.class);
		testRepository = RepositoryFactory.createRepository(TestRepository.class);
		commonServise  = (CommonServise) ServiceFactory.createService(dataSource, 
				new CommonServiseImpl(accountRepository, accountRoleRepository));
		adminService =  (AdminService) ServiceFactory.createService(dataSource,
				new AdminServiceImpl(accountRepository, roleReposotory));
		tutorService = (TutorService) ServiceFactory.createService(dataSource, new TutorServiceImpl(testRepository));
	}

	public void shutdown() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private BasicDataSource buildDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/webtester");
		ds.setUsername("webtester");
		ds.setPassword("123");
		ds.setInitialSize(5);
		ds.setMaxTotal(20);
		return ds;
	}
}
