package webtester.form;

public class LoginForm {
	private String login;
	private String password;
	private int role;
	private Boolean rememberMe;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Boolean isRememberMe() {
		return rememberMe != null && rememberMe.booleanValue();
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}
