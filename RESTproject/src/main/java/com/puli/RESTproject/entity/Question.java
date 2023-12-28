package com.puli.RESTproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Column(name="questionTitle")
    private String questionTitle;
    @Column(name="option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name="option4")
    private String option4;
    @Column(name="correctAnswer")
    private String correctAnswer;
    @Column(name="difficultyLevel")
    private String difficultyLevel;
    @Column(name="category")
    private String category;
}
