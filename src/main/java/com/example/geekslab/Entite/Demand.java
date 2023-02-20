package com.example.geekslab.Entite;

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
public class Demand implements Serializable {
    // le chefService fait une demande pour les equipement
}
