package com.puli.RESTproject.repository;

import com.puli.RESTproject.entity.Question;
import com.puli.RESTproject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizInterface extends JpaRepository<Quiz,Long> {
   // ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title);
}
