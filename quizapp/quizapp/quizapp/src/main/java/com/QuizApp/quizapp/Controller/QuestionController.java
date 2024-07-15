package com.QuizApp.quizapp.Controller;
//import org.apache.el.stream.Optional;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
//package com.QuizApp.quizapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizApp.quizapp.Questions;
import com.QuizApp.quizapp.service.QuestionService;

//import jakarta.persistence.PostLoad;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
     
    @Autowired
    QuestionService questionService;

     @GetMapping("allQuestions")
     public List<Questions> getAllQuestions(){
        
        return questionService.getAllQuestions();
     }

     @GetMapping("category/{category}")
     public List<Questions> getQuestionBasedOnCategroy(@PathVariable String category){  

      return questionService.getQuestionBasedOnCategroy(category);
     }

     @PostMapping("createQuestion")
     public String postQuestion(@RequestBody Questions question ){  

      return questionService.postQuestion(question);
     }
     
   @DeleteMapping("deleteRecord/{id}")
     public String deleteQuestion(@PathVariable Long id ){  

      return questionService.deleteQuestion(id);
     }

     @PutMapping("/updateRecord/{id}")
     public Questions updateQuestion(@PathVariable Long id, @RequestBody Questions questionDetails) {
      return questionService.updateQuestion(id, questionDetails);
     }

}
