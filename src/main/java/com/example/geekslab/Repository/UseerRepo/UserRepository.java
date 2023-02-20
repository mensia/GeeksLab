package com.example.geekslab.Repository.UseerRepo;

import com.example.geekslab.Entite.Useer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Useer,Long> {
}
