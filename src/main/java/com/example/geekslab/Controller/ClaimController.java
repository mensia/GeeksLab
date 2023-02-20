package com.example.geekslab.Controller;

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

    /*@PostMapping("/utilisateurs/{userId}/reclamations")
    public ResponseEntity<Claim> ajouterReclamation(@PathVariable Long userId,
                                                    @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                                                    @RequestParam String description) {
        Claim reclamation = serv.ajouterReclamation(userId, date, description);
        return ResponseEntity.ok(reclamation);
    }
*/

    @PostMapping("/add-claim")
    public void ajouterReclamation(@RequestBody Claim reclamation) {
        serv.AddClaim(reclamation);
    }
    @GetMapping("/list-claims")
    public List<Claim> GetallClaims() {
        return serv.GetallClaims();
    }
}
