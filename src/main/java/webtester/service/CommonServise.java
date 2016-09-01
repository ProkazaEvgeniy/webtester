package webtester.service;

import java.util.List;

import webtester.exception.ValidationException;
import webtester.form.LoginForm;
import webtester.model.Account;
import webtester.model.Role;

public interface CommonServise {

	Account login(LoginForm form) throws ValidationException;

	String generateRememberMeToken(Account account);

	Account findByRememberMeToken(String rememberMeToken);

	List<Role> findAll();
}
