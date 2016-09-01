package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.AnswerForm;
import webtester.form.QuestionForm;
import webtester.model.Answer;
import webtester.model.Question;
import webtester.model.Test;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.repository.TestRepository;
import webtester.service.AdvanceTutorService;

public class AdvanceTutorServiceImpl implements AdvanceTutorService {

	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final TestRepository testRepository;
	
	AdvanceTutorServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository, TestRepository testRepository){
		super();
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.testRepository = testRepository;
	}
	
	@Override
	@Transactional
	public Question findByEdit(Long id) {
		return questionRepository.findByID(id);
	}

	@Override
	@Transactional
	public List<Question> findAll() {
		List<Question> questions = questionRepository.findAll();
		for(Question question : questions){
			Test test = testRepository.findByID(question.getIdTest());
			question.setTest(test);
		}
		return questions;
	}

	@Override
	@Transactional(readOnly=false)
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteQuestion(long id) {
		return questionRepository.deleteQuestion(id);
	}

	@Override
	@Transactional(readOnly=false)
	public int update(QuestionForm form) {
		return questionRepository.update(form);
	}
	
	@Override
	@Transactional(readOnly=false)
	public int deleteAnswer(long id) {
		return answerRepository.deleteAnswer(id);
	}

	@Override
	@Transactional
	public List<Answer> findAllAnswer() {
		List<Answer> answers = answerRepository.findAll();
		for(Answer answer : answers){
			Question question = questionRepository.findByID(answer.getIdQuestion());
			answer.setQuestiton(question);
		}
		return answers;
	}
	
	@Override
	@Transactional
	public Answer findByEditAnswer(Long id) {
		return answerRepository.findByEdit(id);
	}
	
	@Override
	@Transactional(readOnly=false)
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}
	
	@Override
	@Transactional(readOnly=false)
	public int update(AnswerForm form) {
		return answerRepository.update(form);
	}
	
	@Override
	@Transactional
	public List<Test> findAllListTest() {
		return testRepository.findAll();
	}
	
	@Override
	@Transactional
	public List<Question> findAllListQuestion() {
		return questionRepository.findAll();
	}
}
