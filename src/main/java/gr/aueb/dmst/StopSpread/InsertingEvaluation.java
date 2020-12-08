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
		
		public static void insertEvaluation() { //beggining of insertEvaluation method

		Scanner sc4 = new Scanner(System.in);
		int choice4 = 0;
		System.out.println("Παρακαλώ εισάγετε τη βαθμολογία σας:");
		System.out.println("Κλίμακα βαθμολογίας: 1 = κακή εφαρμογή, 2 = μέτρια"
				+ "εφαρμογή, 3 = καλή εφαρμογή, 4 = πολύ καλή εφαρμογή");
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

		public void printDomination(){
			arraymarks[0] = this.mark1;
			arraymarks[1] = this.mark2;
			arraymarks[2] = this.mark3;
			arraymarks[3] = this.mark4;
			/**sort thw elements of the array in auousa*/
			Arrays.sort(arraymarks);
			System.out.println();
			//max of elements is the arraymarks[3] element
			storeMax1 = arraymarks[3];
			//sigkrino kaue stoixio me to teleytaio kai Συστεμ
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
		}//ENDING OF printDomination

		//na to olokliroso
		public void reasonOfEvaluation(){ //αποθήκευση σε αρχειο με λογια τι του αρεσε τι δεν του αρεσε
			Scanner sc5 = new Scanner(System.in);
			System.out.println("Αν θέλετε προσθέστε σχόλια για την εφαρμογή StopSpread!");
			//interaction with the user
			System.out.print("Μπορείτε να πληκτρολογήσετε το σχόλιο σας: ");
			sc5.next(); // prosoxi na to akouikeysoume
			System.out.print("Σας Ευχαριστούμε, η κριτική σας μόλις καταχωρήθηκε!");
			System.out.println();
		}
	}









