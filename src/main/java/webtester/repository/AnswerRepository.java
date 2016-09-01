package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.annotation.Update;
import webtester.form.AnswerForm;
import webtester.model.Answer;

public interface AnswerRepository {

	@Select(sql = "select * from answer where id=?")
	Answer findByEdit(Long id);
	
	@Select(sql = "select * from answer")
	@ReturnType(entityClass = Answer.class)
	List<Answer> findAll();
	
	@Select(sql="select answer.name from answer where answer.id_question=?")
	@ReturnType(entityClass = Answer.class)
	List<Answer> findAllByIdQuestion(Long idQuestion);
	
	@Insert(sql="insert into answer values(nextval('answer_seq'),?,?,?)")
	Answer save(Answer answer);
	
	@Delete(sql = "delete from answer where id=?")
	int deleteAnswer(long id);
	
	@Update(sql = "UPDATE answer SET id_question=?, name=?, correct=? where id=?")
	int update(AnswerForm form);
}
