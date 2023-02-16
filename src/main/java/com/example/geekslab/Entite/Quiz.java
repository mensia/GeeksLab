package com.example.geekslab.Entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Course course;
    @JsonIgnoreProperties("quiz")
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    public void addQuestion(Question question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
        question.setQuiz(this);
    }

    // getters and setters
}