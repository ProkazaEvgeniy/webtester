package webtester.service;

import java.util.List;

import webtester.form.AnswerForm;
import webtester.form.QuestionForm;
import webtester.model.Answer;
import webtester.model.Question;

public interface AdvanceTutorService {

	Question findByEdit(Long id);
	
	List<Question> findAll();
	
	Question save(Question question);
	
	int deleteQuestion(long id);
	
	int update(QuestionForm form);
	
	Answer findByEditAnswer(Long id);
	
	List<Answer> findAllAnswer();
	
	Answer save(Answer answer);
	
	int deleteAnswer(long id);
	
	int update(AnswerForm form);
	
}
