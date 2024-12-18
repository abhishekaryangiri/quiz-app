package com.quizapp.controller;

import com.quizapp.model.Question;
import com.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start/{userId}")
    public ResponseEntity<String> startQuiz(@PathVariable String userId) {
        try {
            Long parsedUserId = Long.parseLong(userId);
            String response = quizService.startQuiz(parsedUserId);
            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid userId: must be a numeric value");
        }
    }

//    @GetMapping("/question")
//    public ResponseEntity<Question> getRandomQuestion() {
//        try {
//            Question question = quizService.getRandomQuestion();
//            if (question == null) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                     .body(new Question("No question found", "", "", "", "", 0));
//            }
//            return ResponseEntity.ok(question);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                                 .body(new Question("Error occurred while fetching question", "", "", "", "", 0));
//        }
//    }

    @GetMapping("/process")
    public ResponseEntity<String> processQuiz(@RequestParam(value = "questionId", defaultValue = "0") Long questionId) {
        if (questionId == 0) {
            return ResponseEntity.badRequest().body("questionId is missing or invalid");
        }
        return ResponseEntity.ok("Question processed: " + questionId);
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submitAnswer(
        @PathVariable Long userId, 
        @RequestParam Long questionId, 
        @RequestParam int selectedOption) {

        if (questionId == null || selectedOption == 0) {
            return ResponseEntity.badRequest().body("Invalid or missing questionId or selectedOption");
        }
        try {
            return ResponseEntity.ok(quizService.submitAnswer(userId, questionId, selectedOption));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error processing request: " + e.getMessage());
        }
    }

    @GetMapping("/result/{userId}")
    public String getQuizResult(@PathVariable Long userId) {
        return quizService.getQuizResult(userId);
    }

    // New Feature: Get all questions without answers
    
    
    
    @GetMapping("/question")
    public Map<String, Object> getRandomQuestionWithoutAnswer() {
        // Fetch a random question
        Question randomQuestion = quizService.getRandomQuestion();

        // Check null
        if (randomQuestion == null) {
            throw new IllegalStateException("No questions available");
        }


        Map<String, Object> questionMap = new LinkedHashMap<>();
        questionMap.put("id", randomQuestion.getId());
        questionMap.put("question", randomQuestion.getQuestion());
        questionMap.put("option1", randomQuestion.getOption1());
        questionMap.put("option2", randomQuestion.getOption2());
        questionMap.put("option3", randomQuestion.getOption3());
        questionMap.put("option4", randomQuestion.getOption4());
        
        return questionMap; // Excludes `correctOption`
    }


}
