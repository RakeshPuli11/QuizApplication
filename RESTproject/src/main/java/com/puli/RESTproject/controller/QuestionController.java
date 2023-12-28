package com.puli.RESTproject.controller;

import com.puli.RESTproject.entity.Question;
import com.puli.RESTproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService s;
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return s.getAllQuestions();
    }
    @GetMapping("id/{x}")
    public ResponseEntity<Optional<Question>> fetchById(@PathVariable long x){
        return s.fetchById(x);
    }

    @GetMapping("category/{x}")
    public ResponseEntity<List<Question>> fetchByCategory(@PathVariable String x){
        return s.fetchByCategory(x);
    }

    @PostMapping("add")
    public ResponseEntity<String> AddQuestion(@RequestBody Question x){
        return s.AddQuestion(x);
    }
}
