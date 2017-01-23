
public class main {

	public static void main(String[] args) {
		
		// We create an array of 10000 elements
		int[] myArray = new int[10000]; 
		
		// We create a variable max that will keep track of the max number of divisors for
		// any number
		int max = 0;
		
		// We create an auxiliary variable count that will be used to count the number
		// of divisors of a number. We initialize it to 1 because every number can be 
		// divided by itself and we are just going to count up to half a number to
		// optimize the program.
		int count = 1;
		
		// We iterate through the int array
		// For each number, we check if it's divisible by any numbers ranging from 1
		// up to half of the number (a number N can't be divided by a number that's bigger
		// than N/2)
		
		for (int i = 1; i < myArray.length; i++) {
			for (int j = 1; j <= (int)i/2; j++) {
				if (i % j == 0) {
					count += 1;
				}
				 
			}			
			
			myArray[i] = count;
			
			if (count > max) {
				max = count;					
			}
			count = 1;
		}
		
		System.out.println("Among integers between 1 and 10000,");
		System.out.println("The maximum number of divisors was " + max);
		System.out.println("Numbers with that many divisors include:");
		
		for (int i = 1; i < myArray.length; i++) {
			if (myArray[i] == max) {
				System.out.println(i);
			}
		}
	}

}
