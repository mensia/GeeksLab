package com.example.geekslab.Repository.CourseRepo;

import com.example.geekslab.Entites.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
