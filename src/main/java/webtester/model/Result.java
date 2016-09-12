package webtester.model;

import java.io.Serializable;
import java.sql.Timestamp;

import webtester.annotation.Column;

public class Result implements Serializable {

	private static final long serialVersionUID = -6450669887045205359L;

	private Long id;
	@Column("id_test")
	private Long idTest;
	@Column("id_account")
	private Long idAccount;
	@Column("percent")
	private Double percent;
	@Column("created")
	private Timestamp created;
	@Column("test_name")
	private String testName;

	public Result() {
		super();
	}
	
	public Result(Long idTest, Long idAccount, Double percent, String testName){
		super();
		this.idTest = idTest;
		this.idAccount = idAccount;
		this.percent = percent;
		this.testName = testName;
		this.created = new Timestamp(System.currentTimeMillis());
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

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
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

	@Override
	public String toString() {
		return "Result [id=" + id + ", idTest=" + idTest + ", idAccount="
				+ idAccount + ", percent=" + percent + ", created=" + created
				+ ", testName=" + testName + "]";
	}

	
}
