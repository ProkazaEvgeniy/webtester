package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.annotation.Update;
import webtester.form.AccountForm;
import webtester.model.Account;

public interface AccountRepository {

	@Select(sql = "select * from account where login=?")
	Account findByLogin(String login);

	@Select(sql = "select * from account where id=?")
	Account findByID(Long id);
	
	@Update(sql = "UPDATE account SET login=?, password=?, first_name=?, last_name=?, second_name=?, email=? where id=?")
	int update(AccountForm form);

	@Select(sql = "select * from account order by id")
	@ReturnType(entityClass = Account.class)
	List<Account> findAll();
	
	@Insert(sql = "insert into account values(nextval('account_seq'),?,?,?,?,?,?)")
	Account save(Account account);

	@Delete(sql = "delete from account where id=?")
	int deleteAccount(long id);
}
