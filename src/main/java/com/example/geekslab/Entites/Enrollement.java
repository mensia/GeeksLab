package com.example.geekslab.Entites;

import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Enrollement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; */

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
