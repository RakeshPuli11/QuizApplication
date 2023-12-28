package com.puli.RESTproject.service;

import com.puli.RESTproject.entity.Question;
import com.puli.RESTproject.entity.QuestionWrapper;
import com.puli.RESTproject.entity.Quiz;
import com.puli.RESTproject.entity.QuizResponse;
import com.puli.RESTproject.repository.DAO;
import com.puli.RESTproject.repository.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuizService{
    @Autowired
    private QuizInterface quizRepo;
    @Autowired
    private DAO qs;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {
        List<Question> questions = qs.findRandomQuestionsByCategory(category,numberOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(long x) {
        Optional<Quiz> quizz = quizRepo.findById(x);// retrieving all questions which have been stored in a specific quiz by using it s id
        List<Question> qFromDB = quizz.get().getQuestion();//getting all questions inside quizz table many to many column
        List<QuestionWrapper> qwForUser = new ArrayList<>();// empty list for user
        for(Question q: qFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            qwForUser.add(qw);
        }
        return new ResponseEntity<>(qwForUser,HttpStatus.OK);
    }

    public ResponseEntity<Long> submitQuiz(Long quizId, List<QuizResponse> resp) {
        Quiz quiz = quizRepo.findById(quizId).orElse(null);
        if (quiz == null) {
            // Handle the case where the quiz is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Question> quizQuestions = quiz.getQuestion();
        long count = 0;
        int i = 0;
        for (QuizResponse qr : resp) {
            String userResponse = qr.getResp();
            String correctAnswer = quizQuestions.get(i).getCorrectAnswer();

            if (userResponse != null && userResponse.equals(correctAnswer)) {
                count++;
            }
            i++;
        }
        return new ResponseEntity<>(count, HttpStatus.FOUND);
    }
//    public ResponseEntity<Long> submitQuiz(Long quizId, List<QuizResponse> resp) {
//        Quiz quiz = quizRepo.findById(quizId).get();
//        List<Question> quizQuestions = quiz.getQuestion();
//        long count = 0;
//        int i = 0;
//        for(QuizResponse qr : resp)
//        {
//        if(qr.getResp().equals(quizQuestions.get(i).getCorrectAnswer()))
//        {
//            count++;
//        }
//        i++;
//    }
//    return new ResponseEntity<>(count,HttpStatus.FOUND);
//    }
}
