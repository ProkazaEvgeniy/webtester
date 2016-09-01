package webtester.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;

import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.RepositoryFactory;
import webtester.repository.RoleRepository;
import webtester.repository.TestRepository;
import webtester.service.AdminService;
import webtester.service.AdvanceTutorService;
import webtester.service.CommonServise;
import webtester.service.StudentService;
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
//Repository
	private final AccountRepository accountRepository;
	private final AccountRoleRepository accountRoleRepository;
	private final RoleRepository roleReposotory;
	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
//Servise
	private final CommonServise commonServise;
	private final AdminService adminService;
	private final BasicDataSource dataSource;
	private final TutorService tutorService;
	private final AdvanceTutorService advanceTutorService;
	private final StudentService studentService;

	public CommonServise getCommonServise() {
		return commonServise;
	}

	public AdminService getAdminService() {
		return adminService;
	}
	
	public TutorService getTutorService(){
		return tutorService;
	}
	
	public AdvanceTutorService getAdvanceTutorService(){
		return advanceTutorService;
	}
	
	public StudentService getStudentService(){
		return studentService;
	}

	private ServiceManager() {
		dataSource = buildDataSource();
		accountRepository = RepositoryFactory.createRepository(AccountRepository.class);
		accountRoleRepository = RepositoryFactory.createRepository(AccountRoleRepository.class);
		roleReposotory = RepositoryFactory.createRepository(RoleRepository.class);
		testRepository = RepositoryFactory.createRepository(TestRepository.class);
		questionRepository = RepositoryFactory.createRepository(QuestionRepository.class);
		answerRepository = RepositoryFactory.createRepository(AnswerRepository.class);
		
		commonServise  = (CommonServise) ServiceFactory.createService(dataSource, 
				new CommonServiseImpl(accountRepository, accountRoleRepository,roleReposotory));
		adminService =  (AdminService) ServiceFactory.createService(dataSource,
				new AdminServiceImpl(accountRepository, roleReposotory, accountRoleRepository));
		tutorService = (TutorService) ServiceFactory.createService(dataSource, new TutorServiceImpl(testRepository, accountRepository));
		advanceTutorService = (AdvanceTutorService) ServiceFactory.createService(dataSource, new AdvanceTutorServiceImpl(questionRepository,answerRepository,testRepository));
		studentService = (StudentService) ServiceFactory.createService(dataSource, new StudentServiceImpl(testRepository,questionRepository,answerRepository));
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
