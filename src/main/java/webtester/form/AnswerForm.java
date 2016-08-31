package webtester.form;

public class AnswerForm {

	private Long idQuestion;
	private String name;
	private Boolean correct;
	private Long id;

	public AnswerForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCorrect() {
		if (correct != null) {
			return correct != null && correct.booleanValue();
		} else
			return false;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

}
