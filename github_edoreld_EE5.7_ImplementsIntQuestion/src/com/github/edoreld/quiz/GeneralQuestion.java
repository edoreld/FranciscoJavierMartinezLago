package com.github.edoreld.quiz;

public class GeneralQuestion implements IntQuestion {
	
	private String question;
	private int answer; 
	
	public GeneralQuestion(String q, int a ) {
		this.question = q;
		this.answer= a;
	}
	public String getQuestion() { 
		return question;
	}
	
	public int getCorrectAnswer() {
		return answer;
	}
	

}
