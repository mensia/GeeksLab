package com.example.geekslab.Entite;

import java.io.Serializable;

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


public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Getters and setters for each property
}

