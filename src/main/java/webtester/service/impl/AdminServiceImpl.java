package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.repository.AccountRepository;
import webtester.repository.AccountRoleRepository;
import webtester.repository.RoleRepository;
import webtester.service.AdminService;

class AdminServiceImpl implements AdminService {

	private final AccountRepository accountRepositry;
	private final RoleRepository roleRepository;
	private final AccountRoleRepository accountRoleRepository;

	AdminServiceImpl(AccountRepository accountRepositry,
			RoleRepository roleRepository,
			AccountRoleRepository accountRoleRepository) {
		super();
		this.accountRepositry = accountRepositry;
		this.roleRepository = roleRepository;
		this.accountRoleRepository = accountRoleRepository;
	}

	@Override
	@Transactional
	public List<Account> findAll() {
		return accountRepositry.findAll();
	}

	@Override
	@Transactional
	public Account findByEdit(Long id) {
		return accountRepositry.findByEdit(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int update(AccountForm form) {
		return accountRepositry.update(form);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteAccount(long id) {
		return accountRepositry.deleteAccount(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Account save(Account account) {
		return accountRepositry.save(account);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteRole(long id) {
		return roleRepository.deleteRole(id);
	}

	@Override
	@Transactional(readOnly = false)
	public AccountRole save(AccountRole accountRole) {
		return accountRoleRepository.save(accountRole);
	}

	@Override
	@Transactional
	public List<AccountRole> findIdAccountRole(Long idAccount) {
		return accountRoleRepository.findIdAccountRole(idAccount);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteAccountRole(long idAccount, long idRole) {
		return accountRoleRepository.deleteAccountRole(idAccount, idRole);
	}
}
