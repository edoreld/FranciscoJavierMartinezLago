package com.github.edoreld.utils;

public class RepeatChar {
	/**
	 * Prints a specific character a number of times on the screen then prints a newline
	 * @param c: the string to repeat
	 * @param n: the number of times we want to print the string
	 */
	public static void repeatCharln(String c, int n) {
		repeatChar(c, n);
		System.out.println("");
	}
	
	/**
	 * Prints a specific character a number of times on the screen
	 * @param c: the string to repeat
	 * @param n: the number of times we want to print the string
	 */
	public static void repeatChar(String c, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(c);
		}
	}
}
