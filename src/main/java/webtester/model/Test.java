package webtester.model;

import java.io.Serializable;
import java.util.List;

import webtester.annotation.Column;

public class Test implements Serializable {

	private static final long serialVersionUID = 386830578402508555L;

	@Column("id_account")
	private Long idAccount;
	@Column("name")
	private String name;
	@Column("description")
	private String description;
	@Column("duration_per_question")
	private Integer durationPerQuestion;
	private transient Account account;
	private transient List<Question> question;
	private transient List<Answer> answer;
	@Column("id")
	private Long id;

	public Test() {
		super();
	}
	
	public Test(Long idAccount, String name, String description,
			Integer durationPerQuestion) {
		super();
		this.idAccount = idAccount;
		this.name = name;
		this.description = description;
		this.durationPerQuestion = durationPerQuestion;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDurationPerQuestion() {
		return durationPerQuestion;
	}

	public void setDurationPerQuestion(Integer durationPerQuestion) {
		this.durationPerQuestion = durationPerQuestion;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", idAccount=" + idAccount + ", name=" + name
				+ ", description=" + description + ", durationPerQuestion="
				+ durationPerQuestion + "]";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	
	
}
