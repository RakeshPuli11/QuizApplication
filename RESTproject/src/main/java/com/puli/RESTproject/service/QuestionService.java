package com.puli.RESTproject.service;

import com.puli.RESTproject.entity.Question;
import com.puli.RESTproject.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class QuestionService{

    @Autowired
    private DAO repo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Optional<Question>> fetchById(long x) {
        try{
        return new ResponseEntity<>(repo.findById(x),HttpStatus.OK);}
        catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(repo.findById(x), HttpStatus.BAD_REQUEST);// marchu bro
    }

    public ResponseEntity<String> AddQuestion(Question x) {
        repo.save(x);
        return new ResponseEntity<>("ok",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> fetchByCategory(String x) {
        try{
        return new ResponseEntity<>(repo.findByCategory(x),HttpStatus.OK);}
        catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

//    public List<Question> fetchBycategory(String x) {
//        return repo.fetchBycategory(x);
//    }
}
