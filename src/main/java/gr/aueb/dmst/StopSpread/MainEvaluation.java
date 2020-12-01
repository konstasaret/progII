//na prosueso ejereseis
//na bgei i main

package gr.aueb.dmst.StopSpread;
/**author
 * Evaggelia
 * this class appears our app evaluation
 * and offers the user the choices of both 
 * evaluate out up and write sxolia
 */

public class MainEvaluation {
	
	public static void main(String [] args){
		/**declaration of Scanner*/
		Scanner sc = new Scanner(System.in);
		/**declaration of the variable stores user's choice*/
		int userchoice = 0;
		boolean flag3 = true;
		/*creation of Objects*/

		Menous objectMenouEvaluation = new Menous();
		InsertingEvaluation objectAlreadyEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectInsertingEvaluation = new InsertingEvaluation();
		InsertingEvaluation objectMax = new InsertingEvaluation();
		InsertingEvaluation objectReason = new InsertingEvaluation();


		while(flag3){//beggining of loop
		/**Appears the Evaluation Menu*/
		objectMenouEvaluation.printMenu();

		userchoice = sc.nextInt();

		switch(userchoice){ //beggining of switch
		case 1:
		objectInsertingEvaluation.printEvaluation();
		//objectMax.printDomination(); //1,2,3,4 kiriarxei max pio exei sigkenrosei ta perissotera
		//objectReason.reasonOfEvaluation(); //logos pou den eimai eyxaristimenos
		break;
		case 2:
		objectInsertingEvaluation.insertEvaluation();
		break;
		case 3 :
		flag3 = false;



		}//ending of switch
		}//ending of loop
	 }
	}