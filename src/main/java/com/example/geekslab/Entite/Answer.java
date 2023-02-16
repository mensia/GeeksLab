package com.example.geekslab.Entite;

import java.io.Serializable;/* */

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Boolean correct;

    @ManyToOne
    private Question question;



    // getters and setters
}
