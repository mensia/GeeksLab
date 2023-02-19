package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.Lesson;
import com.example.geekslab.IService.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final ICourseService courseService;

    public LessonController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Lesson> findAll() {
        return courseService.findAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson findById(@PathVariable Long id) {
        return courseService.findLessonById(id);
    }

    @PostMapping
    public Lesson create(@RequestBody Lesson lesson) {
        return courseService.createLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson update(@PathVariable Long id, @RequestBody Lesson lesson) {
        return courseService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteLesson(id);
    }
}