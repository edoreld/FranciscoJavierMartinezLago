package com.github.edoreld;

import java.util.ArrayList;
import java.util.Collections;

import com.github.edoreld.text.TextIO;

public class AlphabeticalList {

	public static void main(String[] args) {
		
		TextIO text = new TextIO();
		System.out.println("Please enter your input: ");
		String answer = TextIO.getln();
		// [A, B, B] 
		String[] result = answer.split("\\s");
		String[] uniqueResult;
		
		ArrayList<String> wordList = new ArrayList();
		
		for (int i = 0; i < result.length; i++) 
		{
			Boolean dupe = false;
			String firstWord = result[i];
			for (int j = i + 1; j < result.length; j++)
			{
				String secondWord = result[j];
				if (firstWord.equals(secondWord)) 
				{
					dupe = true;
				}
			}
			if (!dupe) {
				wordList.add(firstWord.toLowerCase());
			}
		}	
		
		Collections.sort(wordList);
		
		System.out.print(wordList);

	}

}
