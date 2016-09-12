package webtester.form;

public class NextQuestionForm {

	private Integer offset;
	private Boolean varAnswer;
	private Long idTest;
	private Long idQuestion;
	private String[] idAnswer;
	private String name;

	public NextQuestionForm() {
		super();
	}
	
	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Boolean getVarAnswer() {
		return varAnswer;
	}

	public void setVarAnswer(Boolean varAnswer) {
		this.varAnswer = varAnswer;
	}

	public String[] getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(String[] idAnswer) {
		this.idAnswer = idAnswer;
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

	
	
}
