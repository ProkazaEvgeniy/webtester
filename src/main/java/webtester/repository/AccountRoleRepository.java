package webtester.repository;

import java.util.List;

import webtester.annotation.Delete;
import webtester.annotation.Insert;
import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.model.AccountRole;

public interface AccountRoleRepository {
	
	@Select(sql = "select * from account_role where id_account=?")
	@ReturnType(entityClass = AccountRole.class)
	List<AccountRole> findIdAccountRole(Long idAccount);
	
	@Insert(sql = "insert into account_role values(nextval('account_role_seq'),?,?)")
	AccountRole save(AccountRole accountRole);
	
	@Delete(sql = "delete from account_role where id_account=? and id_role=?")
	int deleteAccountRole(long idAccount, long idRole);
}
