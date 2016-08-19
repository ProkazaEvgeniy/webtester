package webtester.model;

import java.io.Serializable;

public class Test implements Serializable {

	private static final long serialVersionUID = 386830578402508555L;

	private Long id;
	private Long idAccount;
	private String name;
	private String description;
	private Integer durationPerQuestion;

	public Test() {
		super();
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

}
