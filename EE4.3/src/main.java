import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
	
		
		Scanner stdin = new Scanner(System.in);
		System.out.print("Input a number: ");
		int input = Integer.parseInt(stdin.nextLine());
		
		stdin.close();
		
		/** 
		 * We call the function inside the string that will be output to the screen
		 */
		System.out.println("It took " + rollDice(input) + " rolls to roll " + input);
		
		
		}
	
	public static int rollDice(int targetNumber) throws IllegalArgumentException { 
		
		/**
		 * We generate an exception if the target number is not in the set of 
		 * possible values of the sum of the rolls of the two dice
		 */
		
		if (targetNumber < 2 || targetNumber > 12) 
			throw new IllegalArgumentException(); 
		
		/** 
		 * We use the Random class to generate two random numbers between 1 and 6. 
		 * We use a loop getting the sum of the two rolls until the sum is the target 
		 * number. When it is, we return the number of times we rolled the two dice
		 * to get to the target number and print it to the screen
		 */
		Random rand = new Random();
		
		// Keeps tracks of the number of times the dices have been rolled to reach
		// the target number (min 1)
		int counter = 1;
		
		while ((rand.nextInt(6) + 1) + (rand.nextInt(6) + 1) != targetNumber ) {
			counter ++;
		}
		
		// 
		return counter;		

	}

}
