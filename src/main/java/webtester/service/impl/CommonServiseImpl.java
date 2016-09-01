package webtester.service.impl;

import java.util.List;
import java.util.UUID;

import webtester.annotation.Transactional;
import webtester.exception.ValidationException;
import webtester.form.LoginForm;
import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.model.Role;
import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.RoleRepository;
import webtester.service.CommonServise;

class CommonServiseImpl implements CommonServise {

	private final AccountRepository accountRepositry;
	private final AccountRoleRepository accountRoleRepository;
	private final RoleRepository roleRepository;

	CommonServiseImpl(AccountRepository accountRepositry, AccountRoleRepository accountRoleRepository,RoleRepository roleRepository) {
		super();
		this.accountRepositry = accountRepositry;
		this.accountRoleRepository = accountRoleRepository;
		this.roleRepository = roleRepository;
	}

	@Transactional
	public Account login(LoginForm form) throws ValidationException {
		Account account = accountRepositry.findByLogin(form.getLogin());
		if (account == null) {
			throw new ValidationException("Account not found by login");
		}
		if (!account.getPassword().equals(form.getPassword())) {
			throw new ValidationException("Password is not valid");
		}
		if (!account.getActive()) {
			throw new ValidationException("Account not active");
		}
		List<AccountRole> listRole = accountRoleRepository.findIdAccountRole(account.getId());
		boolean check = false;
		for (AccountRole idRole : listRole) {
			if (idRole.getIdRole() == form.getRole()) {
				check = true;
				break;
			}
		}
		if (!check) {
			throw new ValidationException("Role is not valid");
		}
		return account;
	}

	public Account findByRememberMeToken(String rememberMeToken) {
		if (rememberMeToken == null || rememberMeToken.trim().length() == 0) {
			return null;
		} else {
			return new Account(1L, "admin", "password");
		}
	}

	public String generateRememberMeToken(Account account) {
		return UUID.randomUUID().toString();
	}
	
	@Override
	@Transactional
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	
}
