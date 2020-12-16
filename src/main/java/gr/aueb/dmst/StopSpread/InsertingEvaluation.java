package gr.aueb.dmst.StopSpread;

/**
 * authors Evaggelia Panourgia, 
 * Vicky Violingi, 
 * Chrysoula Alysia Petronella Athitaki
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**class InsertingEvaluation asks from
the user to evaluate the app and user can see 
the already evaluation*/
public class InsertingEvaluation { 
	/**private memembers of the class*/
	/**counts the users who vote 1 = κακή εφαρμογή*/
	private static int mark1; 
	/**counts the users who vote 2 = μέτρια εφαρμογή*/
	private static int mark2; 
	/**counts the users who vote 3 = καλή εφαρμογή*/
	private static int mark3; 
	/**counts the users who vote 4 = πολύ καλή εφαρμογή*/
	private static int mark4; 
	/**counts the total users who evaluate our StopCovidSpread app*/
	private static int totalusers;
	/**holds the maximum among mark1,mark2,mark3,mark4*/
	private static int storeMax1; 
	/**create table that stores the number of each mark */
	static int[] markarray = new int[4];
	/**create a list that stores the critic of user's app*/
	ArrayList<String> list  = new ArrayList<String>();
	/**user enter their evaluation*/
	public static void insertEvaluation() { //beginning of insertEvaluation method
		Scanner sc4 = new Scanner(System.in);
		int choice4 = 0;
		Menus mn = new Menus();
		/**calling the menu of class Menus via the Object mn*/
		mn.insertMenu(); 
		choice4 = Inputs.rangeInt(1, 4);
		//each variable of mark1,..3,2..,4 counts how many vote have  each choice(1,2,3,4)
		if( choice4 == 1) {
			++mark1;
		}if( choice4 == 2) {
			++mark2;
		 }if( choice4 == 3) {
			++mark3;
		}if( choice4 == 4) {
			++mark4;
		}
			++totalusers;
	}
	/**prints the already evaluation*/
	public void printEvaluation() {
		System.out.printf("%d : άτομα ψήφισαν κακή εφαρμογή\n",mark1);
		System.out.printf("%d : άτομα ψήφισαν μέτρια εφαρμογή\n",mark2);
		System.out.printf("%d : άτομα ψήφισαν καλή εφαρμογή\n",mark3);
		System.out.printf("%d : άτομα ψήφισαν πολύ καλή εφαρμογή\n",mark4);
		System.out.printf("%d : συνολικά ψήφισαν\n",totalusers);
	}
	/**print the evaluation which dominates */
	public void printDomination() {
		markarray[0] = InsertingEvaluation.mark1;
		markarray[1] = InsertingEvaluation.mark2;
		markarray[2] = InsertingEvaluation.mark3;
		markarray[3] = InsertingEvaluation.mark4;
		/**sort the elements of the array asc*/
		Arrays.sort(markarray);
		System.out.println();
		//stores in markarray[3] the maximum element 
		storeMax1 = markarray[3];
		System.out.println("Η Γενική Κριτική για την εφαρμογή  είναι: ");
		if( mark1 == storeMax1){
			System.out.println("Η εφαρμογή είναι κακή");
		}
		if( mark2 == storeMax1){
			System.out.println("Η εφαρμογή είναι μέτρια");
		}
		if( mark3 == storeMax1){
			System.out.println("Η εφαρμογή είναι καλή");
		}
		if( mark4 == storeMax1){
			System.out.println("Η εφαρμογή είναι πολύ καλή");
		}
	}//ending printDomination

	/**the user can write their critic about our app*/
	public void reasonOfEvaluation() { 
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Επιθυμείτε να προσθέσετε σχόλια για την εφαρμογή StopSpread;");
		//interaction with the user
		System.out.println("1. ΝΑΙ");
		System.out.println("2. ΟΧΙ");
		int check = Inputs.rangeInt(1, 2);
		if (check == 1) {
			System.out.print("Μπορείτε να πληκτρολογήσετε το σχόλιο σας: ");
			String sxolia = sc5.next();
			list.add(sxolia);
			System.out.print("Σας Ευχαριστούμε, η κριτική σας μόλις καταχωρήθηκε!");
		} else {
			System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας!");
		}
		sc5.close();
	}
}
