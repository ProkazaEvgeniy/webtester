package webtester.service;

import java.util.List;

import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.model.Role;

public interface AdminService {

	List<Account> findAll();
	
	Account findByEdit(Long id);

	int deleteRole(long id);

//	Role save(Role role);
	
	Account save(Account account);
	
	int update(AccountForm form);
	
	int deleteAccount(long id);

}
