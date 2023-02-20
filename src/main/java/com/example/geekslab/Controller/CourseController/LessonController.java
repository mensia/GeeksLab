package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.Lesson;
import com.example.geekslab.IService.ICoursesService.ILessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final ILessonService lessonService;

    public LessonController(ILessonService courseService) {
        this.lessonService = courseService;
    }

    @GetMapping
    public List<Lesson> findAll() {
        return lessonService.findAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson findById(@PathVariable Long id) {
        return lessonService.findLessonById(id);
    }

    @PostMapping
    public Lesson create(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson update(@PathVariable Long id, @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}