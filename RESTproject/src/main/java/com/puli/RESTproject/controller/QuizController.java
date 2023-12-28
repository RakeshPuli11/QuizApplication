package com.puli.RESTproject.controller;

import com.puli.RESTproject.entity.Question;
import com.puli.RESTproject.entity.QuestionWrapper;
import com.puli.RESTproject.entity.QuizResponse;
import com.puli.RESTproject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService qs;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numberOfQuestions,@RequestParam String title){
    return qs.createQuiz(category,numberOfQuestions,title);
    }

    @GetMapping("get/{x}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int x){
        return qs.getQuizQuestions(x);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Long> submitQuiz(@PathVariable Long quizId,@RequestBody List<QuizResponse> resp ){

        return qs.submitQuiz(quizId,resp);
    }
}
