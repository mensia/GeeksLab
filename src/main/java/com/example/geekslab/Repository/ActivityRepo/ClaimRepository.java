package com.example.geekslab.Repository.ActivityRepo;

import com.example.geekslab.Entite.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
