package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Class InsertingEvaluation asks from the user. 
 * to evaluate the application and user can.
 * see the existing evaluation
 * both arithmetic and diagram(rabdogramma(*)).
 */

public class InsertingEvaluation { //beginning of class InsertingEvaluation

	private TCPClient cl = new TCPClient();


	/**
	 * Initiates Evaluation of the app.
	 * @param user_id.
	 *
	 */
	public void printMenuEval(int user_id) {
		//beginning of method printMenuEval
		Menus mn = new Menus();
		Inputs inp = new Inputs();

		// server-client messages
		DataOutputStream outStream = cl.getOutStream();
		String clientMessage;

		while (true) {

			try {
				// for option identification
				clientMessage = "eval";
				outStream.writeUTF(clientMessage);
				outStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} // end of try-catch

			mn.printMenu();
			int option = inp.rangeInt(1, 4);
			try {
				if (option == 1) {
					// for option identification
					clientMessage = "eval01";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					printEvaluation();

				} else if (option == 2) {
					// for option identification
					clientMessage = "eval02";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					insertEvaluation(user_id);
				} else if (option == 3) {
					// for option identification
					clientMessage = "eval03";
					outStream.writeUTF(clientMessage);
					outStream.flush();
					reasonOfEvaluation();

				} else if (option == 4) {
					// for option identification
					clientMessage = "eval04";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // end of try-catch
		} // ending loop
	} //ending of method printMenuEval

	/** users enter their evaluation.
	 * @param user_id : the user id from authentication.
	 * to determine if has voted again.
	 * @throws IOException.
	 */
	public void insertEvaluation(int user_id) throws IOException { 
		// beginning of insertEvaluation method
		Menus mn = new Menus();
		Inputs inp = new Inputs();

		// server-client messages
		DataOutputStream outStream = cl.getOutStream();
		DataInputStream inStream = cl.getInStream();

		// pass user_id
		outStream.writeInt(user_id);
		outStream.flush();

		int idVoted = inStream.readInt();
		if (idVoted == -1) {
			// user has not voted again
			int choice;

			mn.insertMenu();
			choice = inp.rangeInt(1, 5);

			outStream.writeInt(choice);
			outStream.flush();
			System.out.println("Καταγράψαμε την"
					+ "απάντησή σας \nΣας ευχαριστούμε πολύ");

		} else {
			System.out.println("Έχετε ήδη ψηφίσει");
		}


	} //ending of insertEvaluation method

	/**
	 * Prints the existing evaluation.
	 *
	 * @throws IOException
	 */
	public void printEvaluation() throws IOException {
		DataInputStream inStream = cl.getInStream();

		int very_bad = inStream.readInt();
		int bad = inStream.readInt();
		int metria = inStream.readInt();
		int good = inStream.readInt();
		int very_good = inStream.readInt();

		System.out.printf("%d : άτομα ψήφισαν πολύ κακή εφαρμογή\n", very_bad);
		System.out.printf("%d : άτομα ψήφισαν κακή εφαρμογή\n", bad);
		System.out.printf("%d : άτομα ψήφισαν μέτρια εφαρμογή\n", metria);
		System.out.printf("%d : άτομα ψήφισαν καλή εφαρμογή\n", good);
		System.out.printf("%d : άτομα ψήφισαν πολύ καλή εφαρμογή\n", very_good);
		int totalusers = very_bad + bad + metria + good + very_good;
		System.out.printf("%d : συνολικά ψήφισαν\n", totalusers);

		System.out.printf("%-20s : ", "Πολύ κακή εφαρμογή ");
		for (int stars = 0; stars < (double) very_bad / totalusers * 100; stars++) { 
			// beginning of loop
			System.out.print("*"); // prints stars
		} // end of loop0
		System.out.println();
		System.out.printf("%-20s : ", "Kακή εφαρμογή ");
		for (int stars = 0; stars < (double) bad / totalusers * 100; stars++) { 
			// beginning of loop
			System.out.print("*"); // prints stars
		} // end of loop1
		System.out.println();
		System.out.printf("%-20s : ", "Μέτρια εφαρμογή ");
		for (int stars = 0; stars < (double) metria / totalusers * 100; stars++) { 
			// beginning of loop
			System.out.print("*"); // prints stars
		} // end of loop2
		System.out.println();
		System.out.printf("%-20s : ", "Καλή εφαρμογή ");
		for (int stars = 0; stars < (double) good / totalusers * 100; stars++) { 
			// beginning of loop
			System.out.print("*"); // prints stars
		} // end of loop3
		System.out.println();
		System.out.printf("%-20s : ", "Πολύ καλή εφαρμογή ");
		for (int stars = 0; stars < (double) very_good / totalusers * 100; stars++) { 
			// beginning of loop
			System.out.print("*"); // prints stars
		} // end of loop4
		System.out.println();

	}

	/**
	 * Users write their evaluation about our app.
	 * @throws IOException.
	 */
	public void reasonOfEvaluation() throws IOException { 
		//beginning of method reasonOfEvaluation

		DataOutputStream outStream = cl.getOutStream();

		Inputs inp = new Inputs();

		System.out.println("Προσθέστε τα σχόλιά σας για την "
				+ "εφαρμογή StopSpread;");

		String sxolia = inp.stringScanner();
		System.out.println("Είστε σίγουροι οτι θέλετε να δώσετε "
				+ "αυτο το σχόλιο : "+ sxolia + "\n 1.Ναι \n 2.Όχι");
		int ans = inp.rangeInt(1,2);
		if (ans == 1 ) {
			System.out.println("Το σχόλιο στέλνεται αυτή την στιγμή");
		} else {
			// TODO : i think we should just abort it
			System.out.println("Δώστε μας καινούργιο σχόλιο");
			String newSxolio = inp.stringScanner();
			sxolia = newSxolio;
		}
		outStream.writeUTF(sxolia);
		outStream.flush();
		System.out.println("Σας Ευχαριστούμε, η κριτική σας "
				+ "μόλις καταχωρήθηκε!");

	} //ending of method reasonOfEvaluation 

	// TODO : will we show the above comments to other users?
} //ending of class InsertingEvaluation
