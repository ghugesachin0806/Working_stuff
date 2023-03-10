package com.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answers {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;

	@OneToOne(mappedBy = "answer")
	private Questions questions;

	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
