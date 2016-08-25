package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.repository.AccountRepository;
import webtester.repository.RoleRepository;
import webtester.service.AdminService;

class AdminServiceImpl implements AdminService {

	private final AccountRepository accountRepositry;
	private final RoleRepository roleRepository;

	AdminServiceImpl(AccountRepository accountRepositry, RoleRepository roleRepository) {
		super();
		this.accountRepositry = accountRepositry;
		this.roleRepository = roleRepository;
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
	@Transactional(readOnly=false)
	public int update(AccountForm form) {
		return accountRepositry.update(form);
	}
	
	@Override
	@Transactional(readOnly=false)
	public int deleteAccount(long id) {
		return accountRepositry.deleteAccount(id);
	}

	@Override
	@Transactional(readOnly=false)
	public Account save(Account account) {
		return accountRepositry.save(account);
	}

//	@Override
//	@Transactional(readOnly=false)
//	public Role save(Role role) {
//		return roleRepository.save(role);
//	}

	@Override
	@Transactional(readOnly=false)
	public int deleteRole(long id) {
		return roleRepository.deleteRole(id);
	}
}
