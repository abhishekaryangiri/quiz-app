package com.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue

    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "selected_option")
    private int selectedOption;
    @Column(name = "is_correct")
    private boolean isCorrect;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public int getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

    
}
