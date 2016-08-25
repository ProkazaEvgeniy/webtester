package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.model.Test;
import webtester.repository.TestRepository;
import webtester.service.TutorService;

public class TutorServiceImpl implements TutorService {

	private final TestRepository testRepository;
	
	TutorServiceImpl(TestRepository testRepository){
		super();
		this.testRepository = testRepository;
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

}
