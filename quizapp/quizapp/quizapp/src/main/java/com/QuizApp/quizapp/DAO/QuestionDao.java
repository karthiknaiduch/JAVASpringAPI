package com.QuizApp.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApp.quizapp.Questions;
import java.util.List;

public interface  QuestionDao extends  JpaRepository<Questions, Long> {

    List<Questions> findByCategory(String category);

}
