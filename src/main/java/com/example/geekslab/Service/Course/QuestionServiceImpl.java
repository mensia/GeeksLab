package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.Answer;
import com.example.geekslab.Entites.Question;
import com.example.geekslab.IService.ICoursesService.IQuestionService;
import com.example.geekslab.Repository.CourseRepo.AnswerRepository;
import com.example.geekslab.Repository.CourseRepo.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements IQuestionService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question questionDetails) {

        Question existingQuestion = questionRepository.findById(id).orElse(null);
        existingQuestion.setDescription(questionDetails.getDescription());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {

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
