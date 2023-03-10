package com.Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToOne
	@JoinColumn(name = "a_id")
	private Answers answer;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(int questionId, String question, Answers answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answers getAnswer() {
		return answer;
	}

	public void setAnswer(Answers answer) {
		this.answer = answer;
	}

	

}
