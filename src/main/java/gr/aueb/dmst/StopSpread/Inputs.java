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
	 * @param lower_boundary : the lowest number possible
	 * @param upper_boundary : the highest number possible
	 * @return An Integer as : lower_boundary <= Integer <= upper_boundary
	 */
	public int rangeInt(int lower_boundary, int upper_boundary) {
		Scanner in = new Scanner(System.in);// Create a scanner
		int inp = -1;// Initialize input
		try {
			inp = in.nextInt();// Get an Integer
			in.nextLine();// Consume new line character

			// number out of the desired range
			if (inp < lower_boundary || inp > upper_boundary) {
				throw new InputMismatchException();
			}

		} catch (InputMismatchException e) {
			System.err.println("Παρακαλώ εισάγετε αριθμό απο το " + lower_boundary + " μεχρι το " + upper_boundary);
			inp = rangeInt(lower_boundary, upper_boundary);
		}
		return inp;
	}

	/** @return user String input */
	public String stringScanner() {
		Scanner in = new Scanner(System.in);// Create new scanner
		return in.nextLine();// Get a String
	}

}
