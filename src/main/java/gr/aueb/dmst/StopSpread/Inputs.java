package gr.aueb.dmst.StopSpread;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class used to take input from user.
 */
public class Inputs {

	private Scanner in;

	/**
	 * Constructor initializes Scanner
	 */
	public Inputs() {
		in = new Scanner(System.in);
	}

	/**
	 * Handles user input errors and returns an integer in the range of
	 * lower_boundary and upper_boundary including the limits
	 *
	 * @param lower_boundary : the lowest number possible
	 * @param upper_boundary : the highest number possible
	 * @return An Integer as : lower_boundary <= Integer <= upper_boundary
	 */
	public int rangeInt(int lower_boundary, int upper_boundary) {
		int inp = -1;// Initialize input
		try {
			inp = in.nextInt();// Get an Integer

			// number out of the desired range
			if (inp < lower_boundary || inp > upper_boundary) {
				throw new InputMismatchException();
			} // end of if

			in.nextLine(); // Consume the next line character

		} catch (InputMismatchException e) {
			System.err.println("Παρακαλώ εισάγετε αριθμό απο το " + lower_boundary + " μεχρι το " + upper_boundary);
			in.nextLine(); // Consume the next line character
			inp = rangeInt(lower_boundary, upper_boundary);
		} // end of try-catch
		return inp;
	} // end of rangeInt(int lower_boundary, int upper_boundary)

	/** @return user String input */
	public String stringScanner() {
		return in.nextLine();// Get a String
	} // end of stringScanner()

} // end of class
