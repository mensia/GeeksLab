package com.example.geekslab.Entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class StudentTest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Quiz quiz;

   /* @ManyToOne
    private Useer student;*/

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer chosenAnswer;

    @ManyToOne
    private Answer correctAnswer;

}
