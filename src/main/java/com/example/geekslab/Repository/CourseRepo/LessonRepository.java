package com.example.geekslab.Repository.CourseRepo;

import com.example.geekslab.Entites.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
