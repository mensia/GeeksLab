package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.*;
import com.example.geekslab.IService.ICoursesService.IAnswerService;
import com.example.geekslab.Repository.CourseRepo.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements IAnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Answer> findAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Long id, Answer answerDetails) {

        Answer existingAnswer = answerRepository.findById(id).orElse(null);
        existingAnswer.setDescription(existingAnswer.getDescription());
        return answerRepository.save(existingAnswer);
    }

    @Override
    public void deleteAnswer(Long id) {

    }

    @Override
    public Question addAnswerToQuestion(Long questionId, Long answerId){

        Answer answer = answerRepository.findById(answerId)
                .orElse(null);

        Question question = questionRepository.findById(questionId)
                .orElse(null);

        if (question.getAnswers().contains(answer)) {
            throw new IllegalArgumentException("answer already exists in Question");
        }

        question.addAnswer(answer);
        return questionRepository.save(question);
    }
}

