package com.example.geekslab.IService.ICoursesService;

import com.example.geekslab.Entites.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findAllLessons();
    Lesson findLessonById(Long id);
    Lesson createLesson(Lesson lesson);
    Lesson updateLesson(Long id, Lesson lessonDetails);
    void deleteLesson(Long id);
}
