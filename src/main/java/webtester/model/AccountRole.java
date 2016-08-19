package webtester.model;

import java.io.Serializable;

import webtester.annotation.Column;

public class AccountRole implements Serializable {

	private static final long serialVersionUID = -3572460782038416656L;
	@Column("id")
	private Long id;
	@Column("id_account")
	private Long idAccount;
	@Column("id_role")
	private int idRole;

	public AccountRole() {
		super();
	}

	public AccountRole(Long idAccount, int idRole) {
		super();
		this.idAccount = idAccount;
		this.idRole = idRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

}
