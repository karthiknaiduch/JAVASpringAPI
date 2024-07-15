package com.QuizApp.quizapp.service;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
//import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApp.quizapp.Questions;
import com.QuizApp.quizapp.DAO.QuestionDao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired 
    QuestionDao questionDao;
    public List<Questions> getAllQuestions() {
     
        return questionDao.findAll();
        
    }

    public List<Questions> getQuestionBasedOnCategroy(String category) {
     
        return questionDao.findByCategory(category);
        
    }

     public String postQuestion( Questions question ){  

       questionDao.save(question);
       return "Success 200";
     }
     
     public String deleteQuestion( Long id ){  

        questionDao.deleteById(id);
        return "Success 200";
      }
    
      public Questions updateQuestion(Long id, Questions questionDetails) {
        Questions question = questionDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Question not found with id: " + id));
        question.setQuizId(questionDetails.getQuizId());
        question.setQuestionText(questionDetails.getQuestionText());
        question.setCategory(questionDetails.getCategory());
        question.setCategoryType(questionDetails.getCategoryType());

        return questionDao.save(question);
    
    }

}
