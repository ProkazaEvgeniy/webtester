package webtester.service;

import java.util.List;

import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.model.AccountRole;

public interface AdminService {

	List<Account> findAll();
	
	Account findByEdit(Long id);

	int deleteRole(long id);

//	Role save(Role role);
	
	Account save(Account account);
	
	int update(AccountForm form);
	
	int deleteAccount(long id);
	
	int deleteAccountRole(long idAccount, long idRole);
	
	AccountRole save(AccountRole accountRole);
	
	List<AccountRole> findIdAccountRole(Long idAccount);
	
	Account findByLogin(String login);

}
