package com.example.geekslab.Service.Course;

import com.example.geekslab.Entites.Lesson;
import com.example.geekslab.IService.ICoursesService.ILessonService;
import com.example.geekslab.Repository.CourseRepo.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

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
}
