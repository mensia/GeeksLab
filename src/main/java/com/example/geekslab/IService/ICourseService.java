package com.example.geekslab.IService;

import com.example.geekslab.Entites.*;
import com.example.geekslab.Entites.Answer;

import java.util.List;

public interface ICourseService {
    List<Course> findAllCourses();
    Course findCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);

    List<Lesson> findAllLessons();
    Lesson findLessonById(Long id);
    Lesson createLesson(Lesson lesson);
    Lesson updateLesson(Long id, Lesson lessonDetails);
    void deleteLesson(Long id);

    List<Quiz> findAllQuizzes();
    Quiz findQuizById(Long id);
    Quiz createQuiz(Quiz quiz);
    Quiz updateQuiz(Long id, Quiz quizDetails);
    void deleteQuiz(Long id);

    List<Question> findAllQuestions();
    Question findQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question questionDetails);
    void deleteQuestion(Long id);

    List<Answer> findAllAnswers();
    Answer findAnswerById(Long id);
    Answer createAnswer(Answer answer);
    Answer updateAnswer(Long id, Answer answerDetails);
    void deleteAnswer(Long id);

    Quiz addQuestionToQuiz(Long quizId, Long questionId);
    Question addAnswerToQuestion(Long questionId, Long answerId);
}
