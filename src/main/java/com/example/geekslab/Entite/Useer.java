package com.example.geekslab.Entite;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

public class Useer implements Serializable {


    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Claim> Claim;
}
