package gr.aueb.dmst.StopSpread;

import java.io.IOException;

/**Shows our app evaluation
 * and offers the user the choices of both
 * evaluate out up and write comments
 */
/**
 * authors Evaggelia, Vicky, Chrysoula
 */
public class MainEvaluation { // beginning of class
	/** Declaration of the variable stores user's choice. */
	public static void mainEval() {
		int userchoice = 0;
		boolean flag3 = true;
		// calling of MenouEvaluation
		Menus objectMenouEvaluation = new Menus();
		Inputs inp = new Inputs();

		// creation of Objects
		InsertingEvaluation objectAlreadyEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectMax = new InsertingEvaluation();
		InsertingEvaluation objectReason = new InsertingEvaluation();
		InsertingEvaluation rb = new InsertingEvaluation();
		InsertingEvaluation insertEvaluation = new InsertingEvaluation();

		while (flag3) { // beginning of loop
			// Shows the Evaluation Menu
			objectMenouEvaluation.printMenu();
			System.out.printf(" %s \n", "Παρακαλώ εισάγετε την επιλογή σας: ");
			userchoice = inp.rangeInt(1, 4);
			switch (userchoice) { // beginning of switch
			case 1:
				// print the existing evaluation
				try {
					objectAlreadyEvaluation.printEvaluation();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rb.printRabdogramma();
				/*
				 * it shows which critic dominates-bad, metria, kali, poli kali app or
				 * combinations of them
				 */
				objectMax.printDomination();
				break;
			case 2:
				/*
				 * the user choosing this alternative can evaluate our app from 1(0ne) to
				 * 4(four) 1 = very bad , 2 = bad ,3 = metria , 4 = good, 5 = very good
				 */
				insertEvaluation.insertEvaluation();
				break;
			case 3:
				/*
				 * the user choosing this alternative can write their critics about our app
				 */
				objectReason.reasonOfEvaluation();
				break;
			case 4:
				flag3 = false;
			} // end of switch
		} // end of loop
	} // end of main
} // end of class MainEvaluation