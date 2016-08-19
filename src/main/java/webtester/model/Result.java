package webtester.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Result implements Serializable {

	private static final long serialVersionUID = -6450669887045205359L;

	private Long id;
	private Long idTest;
	private Long idAccount;
	private Object percent;
	private Timestamp created;
	private String testName;

	public Result() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public Object getPercent() {
		return percent;
	}

	public void setPercent(Object percent) {
		this.percent = percent;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
