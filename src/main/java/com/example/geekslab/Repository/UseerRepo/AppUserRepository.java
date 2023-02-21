package com.example.geekslab.Repository.UseerRepo;

import com.example.geekslab.Entites.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
