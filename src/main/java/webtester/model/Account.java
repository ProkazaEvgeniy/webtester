package webtester.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import webtester.annotation.Column;
import webtester.servlet.AbstractServlet;

public class Account extends AbstractServlet implements Serializable {

	private static final long serialVersionUID = 5528697238697845381L;
	private Long id;
	@Column("login")
	private String login;
	@Column("password")
	private String password;
	@Column("first_name")
	private String firstName;
	@Column("last_name")
	private String lastName;
	@Column("second_name")
	private String secondName;
	@Column("email")
	private String email;
	private Boolean active;
	private Timestamp created;
	private transient List<AccountRole> listRole;
	
	public Account() {
		super();
	}

	public Account(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Account(String login, String password, String firstName, String lastName, String secondName, String email) {
		super();
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.secondName = secondName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", secondName=" + secondName + ", email=" + email
				+ ", active=" + active + ", created=" + created + "]";
	}

	public void setListRole(List<AccountRole> listRole) {
		this.listRole = listRole;
	}

	public List<AccountRole> getListRole() {
		return listRole;
	}
}
