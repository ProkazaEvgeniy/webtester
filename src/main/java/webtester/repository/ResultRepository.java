package webtester.repository;

import java.util.List;

import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.model.Result;

public interface ResultRepository {

	@Select(sql="select * from result order by id")
	@ReturnType(entityClass = Result.class)
	List<Result> findAllResult();
	
	@Select(sql="select * from result where id_account=?")
	@ReturnType(entityClass = Result.class)
	List<Result> findResultByIDAccount(Long idAccount);
	
	@Insert(sql = "insert into result (id, id_test, id_account, percent, test_name) values(nextval('result_seq'),?,?,?,?)")
	Result save(Result result);
}
