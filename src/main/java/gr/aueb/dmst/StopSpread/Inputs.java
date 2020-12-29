package gr.aueb.dmst.StopSpread;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a class that helps getting a number from user, instead of using class
 * Scanner, and checking if this number is within lower and upper boundary.
 */
public class Inputs {
	/**
	 * Handles user input errors and returns an integer in the range of
	 * lower_boundary and upper_boundary including the limits
	 *
	 * @param lower_boundary
	 * @param upper_boundary
	 * @return An Integer as : lower_boundary <= Integer <= upper_boundary
	 */
	
	public int rangeInt(int lower_boundary, int upper_boundary) {
		Scanner in = new Scanner(System.in);
		int inp = -1;
		inp = in.nextInt();
		in.nextLine();
		if (!isNumberAllowed(lower_boundary, upper_boundary, inp)) {
			System.err.println("Παρακαλώ εισάγετε αριθμό απο το " + lower_boundary + " μεχρι το " + upper_boundary);
			inp = rangeInt(lower_boundary, upper_boundary);
		}
		return inp;
	}
	
	public boolean isNumberAllowed(int lower_boundary, int upper_boundary, int givenInput) {
		return (givenInput >= lower_boundary && givenInput <= upper_boundary);
		
		
	
		
		
		
	}

	/** @return user String input */

	public String stringScanner() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
