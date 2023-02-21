package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.Question;
import com.example.geekslab.Entites.Quiz;
import com.example.geekslab.IService.ICoursesService.IQuizService;
import com.example.geekslab.Repository.CourseRepo.QuestionRepository;
import com.example.geekslab.Repository.CourseRepo.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceImpl implements IQuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz createQuiz(Quiz quiz) { return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Long id, Quiz quizDetails) {

        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        existingQuiz.setName(quizDetails.getName());
        return quizRepository.save(existingQuiz);
    }

    @Override
    public void deleteQuiz(Long id) {

    }

    @Override
    public Quiz addQuestionToQuiz(Long quizId, Long questionId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElse(null);

        Question question = questionRepository.findById(questionId)
                .orElse(null);

        if (quiz.getQuestions().contains(question)) {
            throw new IllegalArgumentException("Question already exists in quiz");
        }

        quiz.addQuestion(question);

        return quizRepository.save(quiz);
    }
}
