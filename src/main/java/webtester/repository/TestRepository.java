package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.annotation.Update;
import webtester.form.TestForm;
import webtester.model.Test;

public interface TestRepository {

	@Insert(sql = "insert into test values(nextval('test_seq'),?,?,?,?)")
	Test save(Test test);

	@Select(sql = "select * from test")
	@ReturnType(entityClass = Test.class)
	List<Test> findAll();

	@Select(sql = "select * from test where id=?")
	Test findByID(Long id);

	@Select(sql = "select * from test where id=?")
	@ReturnType(entityClass = Test.class)
	List<Test> findAllTestForStudent(Long id);

	@Delete(sql = "delete from test where id=?")
	int deleteTest(long id);

	@Update(sql = "UPDATE test SET name=?, description=?, duration_per_question=? where id=?")
	int update(TestForm form);
}
