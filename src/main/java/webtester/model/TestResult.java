package webtester.model;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

	private final List<QuestionAnswer> answers = new ArrayList<>();
	private Test test;

	public List<QuestionAnswer> getAnswers() {
		return answers;
	}
	
	public void add(QuestionAnswer q) {
		answers.add(q);
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

		
}
