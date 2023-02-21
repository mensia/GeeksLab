package com.example.geekslab.IService.ICoursesService;

import com.example.geekslab.Entites.*;
import com.example.geekslab.Entites.Answer;

import java.util.List;

public interface ICourseService {
    List<Course> findAllCourses();
    Course findCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);
    public Course findCourseByName(String name);

}
