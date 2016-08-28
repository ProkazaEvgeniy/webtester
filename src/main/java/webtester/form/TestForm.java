package webtester.form;

public class TestForm {

	private String name;
	private String description;
	private Integer durationPerQuestion;
	private Long id;
	
	public TestForm() {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
