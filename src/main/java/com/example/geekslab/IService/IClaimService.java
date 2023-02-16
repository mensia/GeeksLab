package com.example.geekslab.IService;

import com.example.geekslab.Entite.Claim;

import java.util.List;

public interface IClaimService {

    List<Claim> GetallClaims();
    public Claim AddClaim(Claim claim);

    void delete(long id);
}
