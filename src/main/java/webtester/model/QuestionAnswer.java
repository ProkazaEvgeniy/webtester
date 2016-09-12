package webtester.model;

public class QuestionAnswer {

	private Long idQuestion;
//	private String[] idAnswers;
	private String name;
	
	public QuestionAnswer(Long idQuestion, String name) {
		super();
		this.idQuestion = idQuestion;
		this.name = name;
	}
	public Long getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}
	/*public String[] getIdAnswers() {
		return idAnswers;
	}
	public void setIdAnswers(String[] idAnswers) {
		this.idAnswers = idAnswers;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
