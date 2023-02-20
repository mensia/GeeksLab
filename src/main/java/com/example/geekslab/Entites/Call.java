package com.example.geekslab.Entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Call implements Serializable {
    // chaque fournisseur propose une offre a la demande du ChefService
    // le hcef accepte l offre 'call' qui lui plait
    // une notification est envoyer au fournissur


}
