package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.QuestionAnswer;
import webtester.model.Result;
import webtester.model.Test;
import webtester.model.TestResult;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.ResultRepository;
import webtester.repository.TestRepository;
import webtester.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private final TestRepository testRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final ResultRepository resultRepository;

	StudentServiceImpl(TestRepository testRepository,
			QuestionRepository questionRepository,
			AnswerRepository answerRepository, ResultRepository resultRepository) {
		super();
		this.testRepository = testRepository;
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.resultRepository = resultRepository;
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
		if(question != null){
			List<Answer> answer = answerRepository.findAllByIdQuestion(question.getId());
			question.setAnswer(answer);
		}
		return question;
	}

	@Override
	@Transactional
	public Question findQuestionOffset(Long idTest, Integer offset) {
		Question question = questionRepository.findByIdTestAndOffset(idTest, offset);
		if(question != null){
			List<Answer> answer = answerRepository.findAllByIdQuestion(question.getId());
			question.setAnswer(answer);
		}
		return question;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public Question findQuestionOffset(Long idTest, Integer
	 * offset) { return questionRepository.findByIdTestAndOffset(idTest,
	 * offset); }
	 */

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

	@Override
	@Transactional
	public List<Result> findAllResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=false)
	public Result save(Result result) {
		return resultRepository.save(result);
	}

	@Override
	@Transactional
	public List<Answer> findAllAnswer() {
		return answerRepository.findAllAnswer();
	}

	@Override
	@Transactional
	public Double entryResult(TestResult testResult) {
		Integer countCorrect = 0;
		Double percent = 0.0;
		Answer answer = null;
		for (QuestionAnswer a : testResult.getAnswers()) {
			answer = answerRepository.findByIdQuestion(a.getIdQuestion());
			if (a.getName().equals(answer.getName())) {
				countCorrect++;
			}
		}
		int total = questionRepository.countQuestionsForTest(testResult.getTest().getId());
		percent = (double) ((((double)countCorrect) / total)*100);
		
		return percent;
	}
	
	@Override
	@Transactional
	public List<Result> findResultByIDAccount(Long idAccount) {
		return resultRepository.findResultByIDAccount(idAccount);
	}
}
