package com.example.geekslab.Entite;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Call implements Serializable {
    // chaque fournisseur propose une offre a la demande du ChefService
    // le hcef accepte l offre 'call' qui lui plait
    // une notification est envoyer au fournissur
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
