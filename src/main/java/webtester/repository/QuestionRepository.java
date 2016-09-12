package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.annotation.Update;
import webtester.form.QuestionForm;
import webtester.model.Question;

public interface QuestionRepository {

	@Select(sql = "select * from question where id=?")
	Question findByID(Long id);
	
	@Select(sql = "select * from question")
	@ReturnType(entityClass = Question.class)
	List<Question> findAll();
	
	@Select(sql="select question.* from question where question.id_test=?")
	@ReturnType(entityClass = Question.class)
	List<Question> findAllByIdTest(Long idTest);
	
	@Select(sql="select count(*) from question where question.id_test=?")
	int countQuestionsForTest(Long idTest);
	
	@Select(sql="select question.* from question where question.id_test=? order by id limit 1 offset ?")
	Question findByIdTestAndOffset(Long idTest, Integer offset);
	
	@Select(sql="select question.* from question where question.id_test=?")
	Question findQuestionByIdTest(Long idTest);
	
	@Select(sql="select question.* from question where question.id=?")
	Question findQuestionByID(Long id);
	
	@Select(sql="select id from question where id=$id order by id desc limit 1")
	Question findNextOrPreviousQuestion();
	
	@Select(sql="select ")
	int quantityQuestion(Long idTest);
	
	@Insert(sql="insert into question values(nextval('question_seq'),?,?,?)")
	Question save(Question question);
	
	@Delete(sql = "delete from question where id=?")
	int deleteQuestion(long id);
	
	@Update(sql = "UPDATE question SET id_test=?, name=? where id=?")
	int update(QuestionForm form);
}
