package com.example.geekslab.Entite;

import javax.persistence.*;

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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
