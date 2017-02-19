package com.github.edoreld.sets;

import java.util.TreeSet;
import java.util.Iterator;
/**
 * 
 * @author Javier Martínez
 *
 *	Class that represents a set calculator and has some basic operations that it 
 *  can perform on sets such as union, intersection, etc
 *  
 */
public class SetCalculator {

	private TreeSet<Integer> set1;
	private TreeSet<Integer> set2;
	private Character operation;

	public SetCalculator() {

	}

	/**
	 * Method that takes two sets and returns the set representing their 
	 * intersection
	 * @param set1 the first set
	 * @param set2 the second set
	 * @return the intersection of the two sets
	 */
	private TreeSet<Integer> intersection() {	
		set1.retainAll(set2);
		return set1;
	}

	/**
	 * Method that takes two sets and returns the set representing their
	 * union
	 * @param set1 the first set
	 * @param set2 the second set
	 * @return the union of the two sets
	 */
	private TreeSet<Integer> union() {
		set1.addAll(set2);
		return set1;
	}

	/**
	 * Method that takes two sets and returns the set representing the
	 * subtraction of the second set from the first
	 * @param set1 the first set
	 * @param set2 the second set
	 * @return the subtraction of the second set from the first
	 */
	private TreeSet<Integer> subtraction() {
		set1.removeAll(set2);
		return set1;
	}

	public TreeSet<Integer> performOperation(Character _operation) {
		switch (_operation) {
		case '+':
			return this.union();
		case '-':
			return this.subtraction();
		case '*':
			return this.intersection();
		default:
		}
		return new TreeSet<Integer>();
	}

	/**
	 * Method that parses the query, trying to extract two sets and one operation
	 * and then saving the sets and the operation.
	 * @param query the user's input to be parsed
	 * @return the character corresponding to the operation to execute, or '0' if the input wasn't validated
	 * properly
	 * 
	 */
	public Character isInputValid(String query) {

		// We need at least two empty sets and an operation to do a calculation
		set1 = new TreeSet<Integer>();
		set2 = new TreeSet<Integer>();
		boolean validOperation = true;

		int length = query.length();

		if (length < 5) { return '0'; }

		int i = 0;



		// '  [ 1, 2]'
		while (query.charAt(i) != '[') {
			if (query.charAt(i) == ' ') 
			{
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; } 
			}
			else 
			{
				return '0';
			}
		}

		i++;
		if (isIndexOutOfBounds(i, length)) { return '0'; }

		// // '    1  ,   2]'


		// Have to check that after a number there is a comma or another number that is part of that number

		Character c; // A character to hold the current character we are examining
		String numberString; // A string to allows us to add values to the set bigger than 9

		boolean findingACommaIsOkay = false; 
		boolean findingARightSquareBracketIsOkay = true; 
		boolean findingANumberIsOkay = true;

		while (!(query.charAt(i) == ']')) {
			c = query.charAt(i);
			numberString = "";

			if (Character.isDigit(c) && findingANumberIsOkay) {
				numberString += c;
				i++;
				while (Character.isDigit(query.charAt(i)))
				{
					numberString += query.charAt(i);
					i++;
					if (isIndexOutOfBounds(i, length)) { return '0'; }

				}

				set1.add(Integer.parseInt(numberString));

				findingACommaIsOkay = true;
				findingANumberIsOkay = false;
				findingARightSquareBracketIsOkay = true;

			} else if (c == ',' && findingACommaIsOkay) {
				findingACommaIsOkay = false;
				findingARightSquareBracketIsOkay = false;
				findingANumberIsOkay = true;
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; }
			} else if (c == ' ') {
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; }
			} else {
				return '0';
			}
		}

		if (findingARightSquareBracketIsOkay == false ) {
			return '0';
		}

		i++;
		if (isIndexOutOfBounds(i, length)) { return '0'; }



		// Search for operation
		// '   + [ 2 , 3  ]'

		while (query.charAt(i) != '*' && query.charAt(i) != '-' && query.charAt(i) != '+' )
		{
			c = query.charAt(i);
			if (c == ' ') {
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; }
			}
			else {
				return '0';
			}
		}

		operation = query.charAt(i);

		i++;
		if (isIndexOutOfBounds(i, length)) { return '0'; }

		// '   [ 2 3 4 6]
		// Search for second set

		// Check for 2nd set
		while (query.charAt(i) != '[') {
			if (query.charAt(i) == ' ') 
			{
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; } 
			}
			else 
			{
				return '0';
			}
		}


		i++;
		if (isIndexOutOfBounds(i, length)) { return '0'; }



		// // '    1  ,   2]'

		// Have to check that after a number there is a comma or another number that is part of that number

		findingACommaIsOkay = false; 
		findingARightSquareBracketIsOkay = true; 
		findingANumberIsOkay = true;


		while (!(query.charAt(i) == ']')) {
			c = query.charAt(i);
			numberString = "";

			if (Character.isDigit(c) && findingANumberIsOkay) {
				numberString += c;
				i++;
				while (Character.isDigit(query.charAt(i)))
				{
					numberString += query.charAt(i);
					i++;
					if (isIndexOutOfBounds(i, length)) { return '0'; }

				}

				set2.add(Integer.parseInt(numberString));

				findingACommaIsOkay = true;
				findingANumberIsOkay = false;
				findingARightSquareBracketIsOkay = true;

			} else if (c == ',' && findingACommaIsOkay) {
				findingACommaIsOkay = false;
				findingARightSquareBracketIsOkay = false;
				findingANumberIsOkay = true;
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; }
			} else if (c == ' ') {
				i++;
				if (isIndexOutOfBounds(i, length)) { return '0'; }
			} else {
				return '0';
			}
		}



		if (findingARightSquareBracketIsOkay == false ) {
			return '0';
		}

		return operation;
	}

	/**
	 * Checks if the passed index will lead to an outOfIndex error
	 * @param index the index to be checked
	 * @param length the length of the array for which the index is being checked
	 * @return true if it will result in an error, false otherwise
	 */
	private boolean isIndexOutOfBounds(int index, int length) {
		if (index >= length) {
			return true;
		}		
		return false;
	}
}
