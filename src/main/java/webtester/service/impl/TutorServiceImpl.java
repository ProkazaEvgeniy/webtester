package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.TestForm;
import webtester.model.Account;
import webtester.model.Test;
import webtester.repository.AccountRepository;
import webtester.repository.TestRepository;
import webtester.service.TutorService;

public class TutorServiceImpl implements TutorService {

	private final TestRepository testRepository;
	private final AccountRepository accountRepositry;
	
	TutorServiceImpl(TestRepository testRepository, AccountRepository accountRepositry){
		super();
		this.testRepository = testRepository;
		this.accountRepositry = accountRepositry;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Test save(Test test) {
		return testRepository.save(test);
	}
	
	@Override
	@Transactional
	public List<Test> findAll() {
		List<Test> tests = testRepository.findAll();
		for(Test test : tests){
			Account account = accountRepositry.findByID(test.getIdAccount());
			test.setAccount(account);
		}
		return tests;
	}
	
	@Override
	@Transactional
	public Test findByID(Long id) {
		return testRepository.findByID(id);
	}
	
	@Override
	@Transactional(readOnly=false)
	public int deleteTest(long id){
		return testRepository.deleteTest(id);
	}
	
	@Override
	@Transactional(readOnly = false)
	public int update(TestForm form){
		return testRepository.update(form);
	}

}
