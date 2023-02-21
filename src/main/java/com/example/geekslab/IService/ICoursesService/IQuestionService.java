package com.example.geekslab.IService.ICoursesService;

import com.example.geekslab.Entites.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> findAllQuestions();
    Question findQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question questionDetails);
    void deleteQuestion(Long id);

    Question addAnswerToQuestion(Long questionId, Long answerId);
}
