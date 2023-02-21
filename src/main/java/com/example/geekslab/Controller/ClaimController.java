package com.example.geekslab.Controller;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.IService.IClaimService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClaimController {
    IClaimService serv;

    @PostMapping("/add-claim")
    public void ajouterReclamation(@RequestBody Claim reclamation) {
        serv.AddClaim(reclamation);
    }
    @GetMapping("/list-claims")
    public List<Claim> GetallClaims() {
        return serv.GetallClaims();
    }
    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
        return serv.updateClaim(id, claim);
    }
}
