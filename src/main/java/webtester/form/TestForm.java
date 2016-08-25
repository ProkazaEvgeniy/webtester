package webtester.form;

public class TestForm {

	private Long idAccount;
	private String name;
	private String description;
	private int durationPerQuestion;
	
	public TestForm() {
		super();
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

	public int getDurationPerQuestion() {
		return durationPerQuestion;
	}

	public void setDurationPerQuestion(int durationPerQuestion) {
		this.durationPerQuestion = durationPerQuestion;
	}
	
	
}
