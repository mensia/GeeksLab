package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Claim;
import com.example.geekslab.Entite.Useer;
import com.example.geekslab.IService.IClaimService;
import com.example.geekslab.Repository.ActivityRepo.ClaimRepository;
import com.example.geekslab.Repository.UseerRepo.UseerRepository;

import java.util.Date;
import java.util.List;

public class ClaimService implements IClaimService {


    ClaimRepository repo;

    @Override
    public List<Claim> GetallClaims() {
        return repo.findAll();
    }

    @Override
    public Claim AddClaim(Claim claim) {
     return repo.save(claim);
    }

    @Override
    public void delete(long id) {
    repo.deleteById(id);
    }

    @Override
    public Claim ajouterReclamation(Long userId, Date date, String description) {
        Useer user = UseerRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        Claim reclamation = new Claim();
        reclamation.setUser(user);
        reclamation.setDate(date);
        reclamation.setDescription(description);
        return repo.save(reclamation);    }

    public List<Claim> getReclamationsByUserId(Long userId) {
        return repo.findByUtilisateurId(userId);
    }
}
