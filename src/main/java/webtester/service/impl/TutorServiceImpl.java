package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.TestForm;
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
		return testRepository.findAll();
	}
	
	@Override
	@Transactional
	public Test findByEdit(Long id) {
		return testRepository.findByEdit(id);
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
