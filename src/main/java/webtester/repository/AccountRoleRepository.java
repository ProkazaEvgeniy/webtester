package webtester.repository;

import java.util.List;

import webtester.annotation.ReturnType;
import webtester.annotation.Select;
import webtester.model.AccountRole;

public interface AccountRoleRepository {
	
	@Select(sql = "select * from account_role where id_account=?")
	@ReturnType(entityClass = AccountRole.class)
	List<AccountRole> findIdAccountRole(Long idAccount);
}
