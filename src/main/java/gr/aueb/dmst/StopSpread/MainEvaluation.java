//na prosueso ejereseis
//na bgei i main

package gr.aueb.dmst.StopSpread;

import java.util.Scanner;

/**author
 * Evaggelia
 * this class appears our app evaluation
 * and offers the user the choices of both 
 * evaluate out up and write comments
 */

public class MainEvaluation { //begginig of class
	
//	public static void main(String [] args){
		/**declaration of Scanner*/
		Scanner sc = new Scanner(System.in);
		/**declaration of the variable stores user's choice*/
		int userchoice = 0;
		boolean flag3 = true;
		
		/**calling of MenouEvaluation*/
		Menous objectMenouEvaluation = new Menous();
		/*creation of Objects*/
		InsertingEvaluation objectAlreadyEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectInsertingEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectMax = new InsertingEvaluation();
		InsertingEvaluation objectReason = new InsertingEvaluation();
		InsertingEvaluation objectSxolia = new InsertingEvaluation();

		while(flag3){//beggining of loop
		/**Appears the Evaluation Menu*/
		objectMenouEvaluation.printMenu();

		userchoice = sc.nextInt();

		switch(userchoice){ //beggining of switch
		case 1:
		objectInsertingEvaluation.printEvaluation();
		/**the user calling this class via the objectMax it shows witch critic dominates-kaki,metria
		 * ,kali,poli kali app or  combinations of them */
		objectMax.printDomination(); 
		/**the user calling this class via the objectReason inerts their sxolia about our app*/
		objectReason.reasonOfEvaluation(); 
		break;
		case 2:
		/**the user choosing this alternative can evaluate our app
		 * from 1(0ne) to 4(four) 1 = bad , 2 = moderate ,3 = good , 4 = very good */
		objectInsertingEvaluation.insertEvaluation();
		break;
		case 3:
		/**the user choosing this alternative can write their critics in order to have 
		 * feedbach and can improve our app*/
			objectSxolia.reasonOfEvaluation();
		break;
		case 4 :
		flag3 = false;

		} //ending of switch
		} //ending of loop
//	 } //ending of main
	} //ending of class MainEvaluation