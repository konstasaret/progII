package AirlineDog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
	
	private static Scanner in = new Scanner(System.in);
	
	
	/**Handles user input errors and returns an integer in the range of
	 *  lower_boundary and upper_boundary including the limits*/
	public static int rangeInt(int lower_boundary, int upper_boundary) {
		int inp = -1;
		try {
			inp = in.nextInt();
			in.nextLine();
			if(inp < lower_boundary || inp > upper_boundary) {
				throw new InputMismatchException();
			}
		}catch (InputMismatchException e){
			System.err.println("Παρακαλώ εισάγετε αριθμό απο το "+lower_boundary+" μεχρι το "+upper_boundary);
			inp = rangeInt(lower_boundary, upper_boundary);
		}
		System.out.println("Επιλέξατε : " + inp);
			return inp;	
	}
	/** Returns user String input*/
	public static String stringScanner () {
		
		return in.nextLine();
	}
	
}
