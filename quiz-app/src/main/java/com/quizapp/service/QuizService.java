package com.quizapp.service;

import com.quizapp.model.Question;
import com.quizapp.model.QuizSession;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    // Start a new quiz session
    public String startQuiz(Long userId) {
        return "Quiz session started for user: " + userId;
    }
    


    // Get random question
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return questions.get(rand.nextInt(questions.size()));
    }


    
    // Submit answer and check correctness
    public String submitAnswer(Long userId, Long questionId, int selectedOption) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        boolean isCorrect = selectedOption == question.getCorrectOption();

        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setQuestionId(questionId);
        session.setSelectedOption(selectedOption);
        session.setCorrect(isCorrect);
        quizSessionRepository.save(session);

        return isCorrect ? "Correct answer!" : "Wrong answer!";
    }

    
    
    // Get quiz result (correct and incorrect answers)
    public String getQuizResult(Long userId) {
        List<QuizSession> sessions = quizSessionRepository.findByUserId(userId);
        long correctCount = sessions.stream().filter(QuizSession::isCorrect).count();
        long incorrectCount = sessions.size() - correctCount;

        return "Total Questions: " + sessions.size() + "\nCorrect Answers: " + correctCount + "\nIncorrect Answers: " + incorrectCount;
    }
}
    
    
