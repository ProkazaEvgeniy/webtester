package webtester.service;

import java.util.List;

import webtester.model.Question;
import webtester.model.Test;

public interface StudentService {

	List<Test> findAll();
	
//	List<Test> findAllforPassTest(Long id);
	
	Test findAllforPassTest(Long id);
	
	Question findQuestionByID(Long id);
	
	List<Test> findAllTestForStudent(Long id);
	
}
