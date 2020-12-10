package gr.aueb.dmst.StopSpread;
/**author
 * Evaggelia, Vicky, Chrysoula
 * this class appears our app evaluation
 * and offers the user the choices of both 
 * evaluate out up and write comments
 */
public class MainEvaluation { //beginning of class
	public static void mainEval(){		
		/**declaration of the variable stores user's choice*/
		int userchoice = 0;
		boolean flag3 = true;
		/**calling of MenouEvaluation*/
		Menus objectMenouEvaluation = new Menus();
		/*creation of Objects*/
		InsertingEvaluation objectAlreadyEvaluation = new InsertingEvaluation(); //Ευαγγελία δε χρησιμοποιείται
		//InsertingEvaluation objectInsertingEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectMax = new InsertingEvaluation();
		InsertingEvaluation objectReason = new InsertingEvaluation();
		//InsertingEvaluation objectSxolia = new InsertingEvaluation();
		while(flag3) {//beginning of loop
			/**Appears the Evaluation Menu*/
			objectMenouEvaluation.printMenu();
			System.out.printf(" %s \n", "Παρακαλώ εισάγετε την επιλογή σας: ");
			userchoice = Inputs.rangeInt(1, 4);
			switch (userchoice) { //beginning of switch
			case 1:
				objectAlreadyEvaluation.printEvaluation();
				/**the user calling this class via the objectMax it shows which critic dominates-kaki,metria
				 * ,kali,poli kali app or  combinations of them */
				objectMax.printDomination(); 
				/**the user calling this class via the objectReason inerts their sxolia about our app*/
				//objectReason.reasonOfEvaluation(); 
				break;
			case 2:
				/**the user choosing this alternative can evaluate our app
				 * from 1(0ne) to 4(four) 1 = bad , 2 = moderate ,3 = good , 4 = very good */
				InsertingEvaluation.insertEvaluation();
				break;
			case 3:
				/**the user choosing this alternative can write their critics in order to have 
				 * feedbach and can improve our app*/
				objectReason.reasonOfEvaluation();
				break;
			case 4 :
				flag3 = false;
			} //ending of switch
		} //ending of loop
	 } //ending of main
} //ending of class MainEvaluation