package com.github.edoreld.sets;

import java.util.Scanner;
import com.github.edoreld.sets.SetCalculator;
import com.github.edoreld.utils.RepeatChar;


public class SetCalculatorTest {

	public static void main(String[] args) {
		SetCalculator sc = new SetCalculator();
		String query;
		
		System.out.println("Welcome to Set Calculator | Copyright Javier Martínez 2017");
		System.out.println("This program is able to perform the union, intersection or subtraction between two sets");
		System.out.println("A set starts with a left square bracket followed by numbers separated by commas");
		System.out.println("and ends in a right square bracket");
		System.out.println("Operations: + (union), - (difference), * (intersection)");
		System.out.println("The input should be a set followed by an operation and then");
		System.out.println("another set. Example: [1,2,3] + [4,5,6]");
		RepeatChar.repeatCharln("#",40);
		System.out.println("Please input your operations:");
		
		
		try (Scanner stdin = new Scanner(System.in)) {
			Character c;
			query = new String();
			
			do  
			{
				System.out.printf(">");
				query = stdin.nextLine();
				c = sc.isInputValid(query);
				if (c != '0')  
				{
					System.out.println(sc.performOperation(c));
				}
			} 
			while (query.toLowerCase() != "exit");
		}
	}

}
