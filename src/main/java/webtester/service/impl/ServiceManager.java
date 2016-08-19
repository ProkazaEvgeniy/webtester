package webtester.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;

import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.RepositoryFactory;
import webtester.repository.RoleRepository;
import webtester.service.AdminService;
import webtester.service.CommonServise;

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

	public CommonServise getCommonServise() {
		return commonServise;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	private ServiceManager() {
		dataSource = buildDataSource();
//		accountRepositry = new AccountRepositryImpl();
		accountRepository = RepositoryFactory.createRepository(AccountRepository.class);
		accountRoleRepository = RepositoryFactory.createRepository(AccountRoleRepository.class);
		roleReposotory = RepositoryFactory.createRepository(RoleRepository.class);
//		commonServise = new CommonServiseImpl(accountRepositry, dataSource);
		commonServise  = (CommonServise) ServiceFactory.createService(dataSource, 
				new CommonServiseImpl(accountRepository, accountRoleRepository));
		adminService =  (AdminService) ServiceFactory.createService(dataSource,
				new AdminServiceImpl(accountRepository, roleReposotory));
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
