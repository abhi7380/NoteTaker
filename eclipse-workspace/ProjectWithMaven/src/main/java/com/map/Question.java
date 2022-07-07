package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
    @Id
    @Column(name="question_id")
	private int qusetionId;
	private String question;
	
	
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Answer> answers;
	
	public int getQusetionId() {
		return qusetionId;
	}
	public void setQusetionId(int qusetionId) {
		this.qusetionId = qusetionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Question(int qusetionId, String question, List<Answer> answers) {
		super();
		this.qusetionId = qusetionId;
		this.question = question;
		this.answers = answers;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
