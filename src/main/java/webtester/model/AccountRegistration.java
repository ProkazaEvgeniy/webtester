package webtester.model;

import java.io.Serializable;

public class AccountRegistration implements Serializable {

	private static final long serialVersionUID = 6959587508091004668L;

	private Long idAccount;
	private String code;
	
	public AccountRegistration() {
		super();
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
