package webtester.service;

import webtester.exception.ValidationException;
import webtester.form.LoginForm;
import webtester.model.Account;

public interface CommonServise {

	Account login(LoginForm form) throws ValidationException;

	Account findById(Long id);

	String generateRememberMeToken(Account account);

	Account findByRememberMeToken(String rememberMeToken);

}
