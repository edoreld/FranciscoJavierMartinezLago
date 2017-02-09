import java.util.Random;
import java.util.Scanner;

public class EE4dot7 {
	
	/** 
	 * We create three globally available arrays 
	 */
	public static int[] firstNumberArray = new int[10];
	public static int[] secondNumberArray = new int[10];
	public static int[] answerArray = new int[10];
	
	public static void main(String[] args) {
		/** 
		 * Write a program that administers a basic addition quiz to the user. 
		 * There should be ten questions. Each question is a simple addition 
		 * problem such as 17 + 42, where the numbers in the problem are chosen 
		 * at random (and are not too big). The program should ask the user all 
		 * ten questions and get the user's answers. After asking all the questions, 
		 * the program should print each question again, with the user's answer. 
		 * If the user got the answer right, the program should say so; if not, 
		 * the program should give the correct answer. At the end, tell the user 
		 * their score on the quiz, where each correct answer counts for ten points.

		   The program should use three subroutines, one to create the quiz, one
		   to administer the quiz, and one to grade the quiz. It can use three arrays, 
		   with three global variables of type int[], to refer to the arrays. 
		   The first array holds the first number from every question, the second 
		   holds the second number from every questions, and the third holds the user's 
		   answers.
		 **/
		
		createQuiz();	
		administerQuiz();
		gradeQuiz();
		
		
	}
	
	/**
	 * This method fills the two global arrays firstNumberArray and secondNumberArray with random numbers
	 */
	
	public static void createQuiz() {
		/** 
		 * We initialize the number arrays with random numbers from 1 to 50
		 */
		
		Random rand = new Random();
		
		for (int i = 0; i < firstNumberArray.length; i++) {
			firstNumberArray[i] = rand.nextInt(50) + 1;
			secondNumberArray[i] = rand.nextInt(50) + 1;
		}
	}
	
	/**
	 * This method iterates through the two global arrays firstNumberArray & secondNumberArray and asks
	 * the user what the sum of the values at index 1 through 10 of the arrays is and registers the sum
	 * in another array, answerArray
	 */
	
	public static void administerQuiz() {
		Scanner stdin = new Scanner(System.in);
		
		for (int i = 0; i < firstNumberArray.length; i++) {
			System.out.println("What is " + firstNumberArray[i] + " + " + secondNumberArray[i] + "?");
			
			answerArray[i] = Integer.parseInt(stdin.nextLine());			
		}
		
		stdin.close();
	}
	
	/**
	 * This method prints out the sum of the numbers in the global arrays firstNumberArray and secondNumberArray
	 * and then checks it against the answer given by the user stored in answerArray and prints out the answer
	 * along whether it was correct or not
	 */

	public static void gradeQuiz() {
		for (int i = 0; i < answerArray.length; i++) {
				System.out.println(firstNumberArray[i] + " + " + secondNumberArray[i] + " = " + firstNumberArray[i] + secondNumberArray[i] + ". Your answer of " + answerArray[i] + " is " + (firstNumberArray[i] + secondNumberArray[i] == answerArray[i] ? "correct" : "wrong"));
		}
	}
}
