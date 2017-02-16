package com.github.edoreld.blackjack;

import com.github.edoreld.blackjack.BlackjackHand;
import com.github.edoreld.blackjack.Deck;
import com.github.edoreld.text.TextIO;

import java.util.Random;

public class BlackjackHandTest{

	public static void main(String[] args) {
		
		System.out.println("Welcome to Blackjack © 2017 edoreld");
		repeatCharln("#",35);
		BlackjackHand playerHand;
		Deck deck;
		
		String answer = "?";
		
		do {
			deck = new Deck(false);
			deck.shuffle();
			playerHand = new BlackjackHand();
			
			Random rand = new Random();
			int numberOfCardsToDeal = rand.nextInt((6 - 2) + 1) + 2;
			
			for (int i = 0; i < numberOfCardsToDeal; i++) {
				playerHand.addCard(deck.dealCard());
				}
		
			System.out.println("Your hand is the following:");
			emptyLine();
			repeatCharln("o",20);
			for (int i = 0 ; i < numberOfCardsToDeal ; i++) {
				System.out.println(playerHand.getCard(i));
			}
			repeatCharln("o", 20);
			
			emptyLine();
			System.out.printf("The blackjack value is %d\n", playerHand.getBlackjackValue());
			
			emptyLine();
			System.out.println("Would you like to give it another go? (yes/no)");
			answer = TextIO.getln();
			
			while (!answer.equals("yes") && !answer.equals("no")) {
				System.out.println("Please input either 'yes' or 'no'");
				answer = TextIO.getln();
			}
			
		} 
		while ( !answer.equals("no"));
	}
	
	
	/**
	 * prints an empty line
	 */
	private static void emptyLine() {
		System.out.println("");
	}
	
	/**
	 * Prints a specific character a number of times on the screen then prints a newline
	 * @param c: the string to repeat
	 * @param n: the number of times we want to print the string
	 */
	private static void repeatCharln(String c, int n) {
		repeatChar(c, n);
		System.out.println("");
	}
	
	/**
	 * Prints a specific character a number of times on the screen
	 * @param c: the string to repeat
	 * @param n: the number of times we want to print the string
	 */
	private static void repeatChar(String c, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(c);
		}
	}
}
