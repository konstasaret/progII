package gr.aueb.dmst.StopSpread;

/**
 * author Evaggelia
 */
	
/**ua prepei na filame tiw metrikes vste na menoyn sro programma kai otan termatzi prosoxi*/
/**epipleo stistiki*/
/**exception */

	/**class InsertingEvaluation asks from
	the user to evaluate the app*/
	import java.util.Scanner;

	public class InsertingEvaluation{
		/**private memembers of the class*/

		private int mark1; //counts the users who vote 1 = κακή εφαρμογή
		private int mark2; //counts the users who vote 2 = κακή εφαρμογή
		private int mark3; //counts the users who vote 3 = κακή εφαρμογή
		private int mark4; //counts the users who vote 4 = κακή εφαρμογή
		private int totalusers; //counts the total users who evaluate our Covidapp
		private int storeMax1; //holds the maximum between mark3 and mark4
		private int storeMax2; //holds the maximum between mark3 and mark4
		public void insertEvaluation(){


		Scanner sc4 = new Scanner(System.in);
		int choice4 = 0;
		System.out.println("Παρακαλώ εισάγετε τη βαθμολογία σας");
		System.out.println("κλίμακα βαθμολογίας 1=κακή εφαρμογή,2=μέτρια εφαρμογή 3=καλή εφαρμογή 4=πολύ καλή εφαρμογή");
		System.out.println("Η βαθμολογία μου είναι:");
		choice4 = sc4.nextInt();
		//if that counts how many vote each choice(1,2,3,4)
		if( choice4 == 1){
			++mark1;
		}if( choice4 == 2){
			++mark2;
		 }if( choice4 == 3){
			++mark3;
		}if( choice4 == 4){
			++mark4;
		}
		++totalusers;
		}


		public void printEvaluation(){
		System.out.printf("%d : άτομα ψήφισαν κακή εφαρμογή\n",mark1);
		System.out.printf("%d : άτομα ψήφισαν μέτρια εφαρμογή\n",mark2);
		System.out.printf("%d : άτομα ψήφισαν καλή εφαρμογή\n",mark3);
		System.out.printf("%d : άτομα ψήφισαν πολύ καλή εφαρμογή\n",mark4);
		System.out.printf("%d : συνολικά ψήφισαν\n",totalusers);
		}

		/**public void printDomination(){
		if(Math.max(mark1,mark2)){
			System.out.println("Οι περισσότεροι ψήφισαν ότι η εφαρμογή είναι κακή");
		}
		if(){
		System.out.println("Οι περισσότεροι ψήφισαν ότι η εφαρμογή είναι μέτρια");
		}
		if(){
		System.out.println("Οι περισσότεροι ψήφισαν ότι η εφαρμογή είναι καλή");
		}
		if(){
		System.out.println("Οι περισσότεροι ψήφισαν ότι η εφαρμογή είναι πολύ καλή");
		}
		}*/

		//na to olokliroso
		public void reasonOfEvaluation(){ //αποθικευση σε αρχειο με λογια τι του αρεσε τι δεν του αρεσε
			System.out.println("Αν θέλετε προσθέστε σχόλια για την εφαρμογή Covidapp");


		}


	}









