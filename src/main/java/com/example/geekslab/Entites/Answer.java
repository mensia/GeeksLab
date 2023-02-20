package com.example.geekslab.Entites;

import com.example.geekslab.Entites.Question;
import lombok.*;

import javax.persistence.*;

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
