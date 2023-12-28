package com.puli.RESTproject.repository;

import com.puli.RESTproject.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DAO extends JpaRepository<Question,Long> {


    List<Question> findByCategory(String x);

//    @Query("SELECT q FROM Question q WHERE q.category = :category ORDER BY RAND() LIMIT :numberOfQuestions")
//    List<Question> findRandomQuestionsByCategory(String category, int numberOfQuestions);
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numberOfQuestions);


//    ResponseEntity<List<Question>> getQuizQuestions(int x);
}
