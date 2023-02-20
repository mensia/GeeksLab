package com.example.geekslab.Repository.CourseRepo;

import com.example.geekslab.Entites.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

