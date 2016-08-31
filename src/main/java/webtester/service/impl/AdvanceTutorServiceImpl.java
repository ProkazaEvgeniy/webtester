package webtester.service.impl;

import java.util.List;

import webtester.annotation.Transactional;
import webtester.form.AnswerForm;
import webtester.form.QuestionForm;
import webtester.model.Answer;
import webtester.model.Question;
import webtester.repository.AnswerRepository;
import webtester.repository.QuestionRepository;
import webtester.service.AdvanceTutorService;

public class AdvanceTutorServiceImpl implements AdvanceTutorService {

	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	
	AdvanceTutorServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository){
		super();
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	
	@Override
	@Transactional
	public Question findByEdit(Long id) {
		return questionRepository.findByEdit(id);
	}

	@Override
	@Transactional
	public List<Question> findAll() {
		return questionRepository.findAll();
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
		return answerRepository.findAll();
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
}
