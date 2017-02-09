package com.github.edoreld.quiz;
import com.github.edoreld.quiz.AdditionQuestion;
import com.github.edoreld.quiz.SubtractionQuestion;
import com.github.edoreld.quiz.GeneralQuestion;
import java.util.Scanner;
import java.io.IOException;

public class QuizTaking 
{
	
	private static IntQuestion[] questions;
	private static int[] answers;
	
	public static void main(String[] args) 
	{

		createQuiz();
		administerQuiz();
		gradeQuiz();
	}
	
	private static void gradeQuiz() {
		
		for (int w = 0; w < 40; w++) {
			System.out.println("");
		}
		System.out.println("Computing results, please wait a few seconds...");
		try { 
			for (int j = 0; j < 3; j++) {
				Thread.sleep(1000);
				System.out.print(".");
			}
		} catch (InterruptedException ex) {
			
		}		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("\n##########");
			System.out.printf("Question %d\n", (i + 1));
			System.out.printf("The question was: %s \n", questions[i].getQuestion() );
			System.out.printf("Your answer of %d was ", answers[i]);
			System.out.printf("%s\n", questions[i].getCorrectAnswer() == answers[i] ? " correct!" : " incorrect");
			try { 
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}	
		}
	}

	private static void administerQuiz()  
	{
		System.out.println("Welcome to the quiz. Please answer the following questions for your chance to win a free pony");
		System.out.println("##########");
		
		try {
		Thread.sleep(1000);
		} catch (InterruptedException ex) {
			
		}
		
		Scanner stdin = new Scanner(System.in);
		answers = new int[10];
		
		for (int i = 0; i < 10; i++) 
		{
			System.out.printf("Question %2d\n", i+1);
			System.out.println(questions[i].getQuestion());
			answers[i] = Integer.parseInt(stdin.nextLine());
		}
		
		stdin.close();
	}

	private static void createQuiz() 
	{
		
		questions = new IntQuestion[10];
		
		for (int i = 0; i < 9; i++) 
		{
			if (Math.random() > 0.5)
			{
				questions[i] = new AdditionQuestion();
			}
			else {
				questions[i] = new SubtractionQuestion();
			}
		}
		
		questions[9] = new GeneralQuestion("What is the meaning of life?",42);
		
	}
	
}
