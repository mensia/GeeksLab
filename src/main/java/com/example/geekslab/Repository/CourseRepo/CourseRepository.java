package com.example.geekslab.Repository.CourseRepo;

import com.example.geekslab.Entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
     Course findByName(String name);
}

