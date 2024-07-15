package com.QuizApp.quizapp;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quiz_id")
    private Integer quizId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "category")
    private String category;

    private String categoryType;

}   
