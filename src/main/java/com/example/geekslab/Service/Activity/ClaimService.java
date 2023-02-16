package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Claim;
import com.example.geekslab.IService.IClaimService;
import com.example.geekslab.Repository.ActivityRepo.ClaimRepository;

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
}
