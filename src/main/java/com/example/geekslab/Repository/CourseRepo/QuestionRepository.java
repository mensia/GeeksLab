package com.example.geekslab.Repository.CourseRepo;

import com.example.geekslab.Entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
