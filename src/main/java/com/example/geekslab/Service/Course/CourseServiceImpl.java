package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.*;
import com.example.geekslab.IService.ICourseService;
import com.example.geekslab.Repository.CourseRepo.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public CourseServiceImpl(CourseRepository courseRepository, LessonRepository lessonRepository,
                              QuizRepository quizRepository,
                             QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    //************************************  COURSE ************************************ //
    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElse(null);

        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {

    }

    //************************************ Lesson ************************************ //
    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        Lesson existingLesson = lessonRepository.findById(id)
                .orElse(null);

        existingLesson.setName(lessonDetails.getName());
        existingLesson.setDescription(lessonDetails.getDescription());
        existingLesson.setVideoUrl(lessonDetails.getVideoUrl());

        return lessonRepository.save(existingLesson);
    }

    @Override
    public void deleteLesson(Long id) {

    }


    //************************************ Quiz ************************************ //
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

    //************************************ Question ************************************ //
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

    //************************************ Answer ************************************ //
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

    //************************************ END CRUD ************************************ //

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
