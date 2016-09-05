package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.TestRepository;
import webtester.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	StudentServiceImpl(TestRepository testRepository,
			QuestionRepository questionRepository,
			AnswerRepository answerRepository) {
		super();
		this.testRepository = testRepository;
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}

	@Override
	@Transactional
	public List<Test> findAll() {
		return testRepository.findAll();
	}

	@Override
	@Transactional
	public Test findAllforPassTest(Long id) {
		Test test = testRepository.findByID(id);
		Question question = questionRepository.findQuestionByIdTest(test.getId());
		test.setQuestion(question);
		List<Answer> answer = answerRepository.findAllByIdQuestion(question.getId());
		test.setAnswer(answer);
		return test;
	}
	
	@Override
	@Transactional
	public Question findQuestionByID(Long id) {
		Question question = questionRepository.findQuestionByID(id);
		question.setQuestion(question);
		List<Answer> answer = answerRepository.findAllByIdQuestion(question.getId());
		question.setAnswer(answer);
		return question;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public Test findAllforPassTest(Long id) { Test test =
	 * testRepository.findByID(id); List<Question> questions =
	 * questionRepository.findAllByIdTest(test.getId());
	 * test.setQuestion(questions); for(Question question : questions){
	 * List<Answer> answer =
	 * answerRepository.findAllByIdQuestion(question.getId());
	 * test.setAnswer(answer); } return test; }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public List<Test> findAllforPassTest(Long id) { List<Test>
	 * tests = testRepository.findAllTestForStudent(id); for(Test test : tests){
	 * List<Question> questions =
	 * questionRepository.findAllByIdTest(test.getId());
	 * test.setQuestion(questions); for(Question question : questions){
	 * List<Answer> answer =
	 * answerRepository.findAllByIdQuestion(question.getId());
	 * test.setAnswer(answer); } } return tests; }
	 */

	@Override
	@Transactional
	public List<Test> findAllTestForStudent(Long id) {
		return testRepository.findAllTestForStudent(id);
	}

}
