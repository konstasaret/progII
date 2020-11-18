package AirlineDog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
	
	private static Scanner in = new Scanner(System.in);
	
	public static int rangeInt(int lower_boundary, int upper_boundary) {
		int inp = -1;
		try {
			inp = in.nextInt();
			if(inp < lower_boundary || inp > upper_boundary) {
				throw new InputMismatchException();
			}
		}catch (InputMismatchException e){
			System.err.println("Παρακαλώ εισάγετε αριθμό απο το "+lower_boundary+" μεχρι το "+upper_boundary);
			inp = rangeInt(lower_boundary, upper_boundary);
		}
			return inp;	
	}

	public static String stringScanner () {
		String theString = in.nextLine();

		return theString;
	}
	
}
