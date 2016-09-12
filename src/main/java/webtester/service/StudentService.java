package webtester.service;

import java.util.List;

import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Result;
import webtester.model.Test;
import webtester.model.TestResult;

public interface StudentService {

	List<Test> findAll();
	
//	List<Test> findAllforPassTest(Long id);
	
	Test findAllforPassTest(Long id);
	
	Question findQuestionByID(Long id);
	
	Question findQuestionOffset(Long idTest, Integer offset);
	
	List<Test> findAllTestForStudent(Long id);
	
	List<Result> findAllResult();
	
	Result save(Result result);
	
	List<Answer> findAllAnswer();
	
	Double entryResult(TestResult testResult);
	
	List<Result> findResultByIDAccount(Long idAccount);	
}
