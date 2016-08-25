package webtester.service;

import java.util.List;

import webtester.form.AccountForm;
import webtester.model.Account;

public interface AdminService {

	List<Account> findAll();
	
	Account findByEdit(Long id);

	int deleteRole(long id);

//	Role save(Role role);
	
	Account save(Account account);
	
	int update(AccountForm form/*, long id*/);
	
	int deleteAccount(long id);

}
