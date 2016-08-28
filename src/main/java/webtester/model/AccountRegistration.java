package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class AccountRegistration implements Serializable {

	private static final long serialVersionUID = 6959587508091004668L;

	@Column("id_account")
	private Long idAccount;
	@Column("code")
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
