package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.*;
import com.example.geekslab.IService.ICoursesService.ICourseService;
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

    @Override
    public Course findCourseByName(String name) {

        Course course = courseRepository.findByName(name);
        return course;
    }





    //************************************ END CRUD ************************************ //


}


