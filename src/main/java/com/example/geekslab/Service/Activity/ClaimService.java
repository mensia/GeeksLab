package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.Entite.Useer;
import com.example.geekslab.IService.IClaimService;
import com.example.geekslab.Repository.ActivityRepo.ClaimRepository;
import com.example.geekslab.Repository.UseerRepo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@AllArgsConstructor
public class ClaimService implements IClaimService {


    ClaimRepository repo;
    UserRepository repuser;

    @Override
    public List<Claim> GetallClaims() {
        return repo.findAll();
    }

    @Override
    public Claim AddClaim(Claim claim) {
        return repo.save(claim);
    }

    @Override
    public Claim findClaimById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Claim updateClaim(Long id, Claim claim) {

        Claim oldclaim = repo.findById(id).orElse(null);
        oldclaim.setDescription(oldclaim.getDescription());
        oldclaim.setStatus(oldclaim.getStatus());
        return repo.save(oldclaim);
    }



   /* public void addClaimToUser(Long userId, Claim claim) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        claim.setUser(user);
        user.getClaims().add(claim);

        userRepository.save(user);
    }*/
}
