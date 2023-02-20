package com.example.geekslab.IService.ICoursesService;

import com.example.geekslab.Entites.Answer;
import com.example.geekslab.Entites.Question;

import java.util.List;

public interface IAnswerService {
    List<Answer> findAllAnswers();
    Answer findAnswerById(Long id);
    Answer createAnswer(Answer answer);
    Answer updateAnswer(Long id, Answer answerDetails);
    void deleteAnswer(Long id);

    Question addAnswerToQuestion(Long questionId, Long answerId);
}
