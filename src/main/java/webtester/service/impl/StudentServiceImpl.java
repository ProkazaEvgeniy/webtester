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

	StudentServiceImpl(	TestRepository testRepository,
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
	public List<Test> findAllforPassTest(Long id) {
		List<Test> tests = testRepository.findAll();
		List<Question> questions = questionRepository.findAll();
		for(Test test : tests){
			List<Question> question = questionRepository.findAllByIdTest(id);
			test.setQuestion(question);
			for(Question question1 : questions){
				List<Answer> answer = answerRepository.findAllByIdQuestion(question1.getId());
				test.setAnswer(answer);
			}
		}
		return tests;
	}
	
}
