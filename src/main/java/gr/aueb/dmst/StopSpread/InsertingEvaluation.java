package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Class InsertingEvaluation asks from the user to evaluate the app and user can
 * see the existing evaluation
 */

public class InsertingEvaluation {

	private TCPClient cl = new TCPClient();

	// TODO add javadoc
	/**
	 *
	 */
	public void printMenuEval() {
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

					insertEvaluation();
				} else if (option == 3) {
					// for option identification
					clientMessage = "eval03";
					outStream.writeUTF(clientMessage);
					outStream.flush();

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
	}

	/** users enter their evaluation. */
	public void insertEvaluation() { // beginning of insertEvaluation method
		//TODO o kathenas na mpori na psifisei mia fora
		Menus mn = new Menus();
		Inputs inp = new Inputs();

		try {

			// server-client messages
			DataOutputStream outStream = cl.getOutStream();



			int choice;

			// calling the menu of class Menus via the Object mn
			mn.insertMenu();
			choice = inp.rangeInt(1, 5);
			// each variable of mark1,..3,2..,5 counts how many vote have each
			// choice(1,2,3,4,5)

			outStream.writeInt(choice);
			outStream.flush();

			System.out.println("Καταγράψαμε την απάντησή σας \nΣας ευχαριστούμε πολύ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the existing evaluation.
	 *
	 * @throws IOException
	 */
	public void printEvaluation() {
		DataInputStream inStream = cl.getInStream();

		try {
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



			System.out.printf("%-20s : ","Πολύ κακή εφαρμογή ");
			for (int stars = 0; stars < (double) very_bad/totalusers*100; stars++) { // beginning of loop
				System.out.print("*"); // prints stars
			} // end of loop0
			System.out.println();
			System.out.printf("%-20s : ","Kακή εφαρμογή ");
			for (int stars = 0; stars < (double) bad/totalusers*100; stars++) { // beginning of loop
				System.out.print("*"); // prints stars
			} // end of loop1
			System.out.println();
			System.out.printf("%-20s : ","Μέτρια εφαρμογή ");
			for (int stars = 0; stars < (double) metria/totalusers*100; stars++) { // beginning of loop
				System.out.print("*"); // prints stars
			} // end of loop2
			System.out.println();
			System.out.printf("%-20s : ","Καλή εφαρμογή ");
			for (int stars = 0; stars < (double) good/totalusers*100; stars++) { // beggining of loop
				System.out.print("*"); // prints stars
			} // end of loop3
			System.out.println();
			System.out.printf("%-20s : ","Πολύ καλή εφαρμογή ");
			for (int stars = 0; stars < (double) very_good/totalusers*100; stars++) { // beginning of loop
				System.out.print("*"); // prints stars
			} // end of loop4
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	// Users write their evaluation about our app.
	public void reasonOfEvaluation() throws IOException {
		DataOutputStream outStream = cl.getOutStream();
		Inputs inp = new Inputs();
		System.out.println("Επιθυμείτε να προσθέσετε σχόλια για την εφαρμογή StopSpread;");
		// interaction with the user
		System.out.println("1. ΝΑΙ");
		System.out.println("2. ΟΧΙ");
		int check = inp.rangeInt(1, 2);
		if (check == 1) {
			System.out.print("Μπορείτε να πληκτρολογήσετε το σχόλιο σας: ");
			String sxolia = inp.stringScanner();
			outStream.writeUTF(sxolia);
			outStream.flush();
			System.out.print("Σας Ευχαριστούμε, η κριτική σας μόλις καταχωρήθηκε!");
		} else {
			System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας!");
		}

	}
}