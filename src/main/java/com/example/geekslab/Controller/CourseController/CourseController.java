package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.Course;
import com.example.geekslab.IService.ICoursesService.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @GetMapping("/searchCourse/{nom}")
    public Course findCourse(@PathVariable String nom) {
        return courseService.findCourseByName(nom);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }


}