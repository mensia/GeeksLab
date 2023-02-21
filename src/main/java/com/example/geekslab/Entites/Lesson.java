package com.example.geekslab.Entites;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity


public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Getters and setters for each property
}

