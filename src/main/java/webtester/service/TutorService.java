package webtester.service;

import java.util.List;

import webtester.form.TestForm;
import webtester.model.Test;

public interface TutorService {

	Test save(Test test);
	
	List<Test> findAll();
	
	Test findByEdit(Long id);
	
	int deleteTest(long id);
	
	int update(TestForm form);
}
