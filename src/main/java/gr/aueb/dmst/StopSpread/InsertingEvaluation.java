package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Class InsertingEvaluation asks from the user
 * to evaluate the application and user can
 * see the existing evaluation both
 * arithmetically and through a diagram(rabdogramma(*)).
 */

public class InsertingEvaluation {

	private TCPClient cl = new TCPClient();

	/**
	 * Initiates Evaluation of the application.
	 * @param user_id : The user's id
	 *
	 */
	public void printMenuEval(int user_id) {

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
				System.err.println("Η συνδεση με τον διακομιστή απέτυχε.\n"
						+ "Παρακαλούμε δοκιμάστε αργότερα.");
			} // end of try-catch

			mn.printMenu();
			int option = inp.rangeInt(1, 5);
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

					showComments();

				} else if (option == 5) {
					// for option identification
					clientMessage = "eval05";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					break;

				}
			} catch (IOException e) {
				System.err.println("Η συνδεση με τον διακομιστή απέτυχε.\n"
						+ "Παρακαλούμε δοκιμάστε αργότερα.");
				} // end of try-catch
		} // end loop
	} //end of method printMenuEval

	/** Users enter their evaluation.
	 * @param user_id : the user id from authentication
	 * to determine if he has voted again.
	 * @throws IOException if an I/O error occurs
	 */
	public void insertEvaluation(int user_id) throws IOException {
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
			System.out.println("Καταγράψαμε την απάντησή σας "
					+ "\nΣας ευχαριστούμε πολύ");

		} else {
			System.out.println("Έχετε ήδη ψηφίσει");
		}

	} //end of method insertEvaluation

	/**
	 * Prints the existing evaluation.
	 *
	 * @throws IOException if an I/O error occurs
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
			System.out.print("*");
		} // end of first loop
		System.out.println();

		System.out.printf("%-20s : ", "Kακή εφαρμογή ");
		for (int stars = 0; stars < (double) bad / totalusers * 100; stars++) {
			System.out.print("*");
		} // end of second loop
		System.out.println();

		System.out.printf("%-20s : ", "Μέτρια εφαρμογή ");
		for (int stars = 0; stars < (double) metria / totalusers * 100; stars++) {
			System.out.print("*");
		} // end of third loop
		System.out.println();

		System.out.printf("%-20s : ", "Καλή εφαρμογή ");
		for (int stars = 0; stars < (double) good / totalusers * 100; stars++) {
			System.out.print("*");
		} // end of forth loop
		System.out.println();

		System.out.printf("%-20s : ", "Πολύ καλή εφαρμογή ");
		for (int stars = 0; stars < (double) very_good / totalusers * 100; stars++) {
			System.out.print("*");
		} // end of fifth loop
		System.out.println();

	} //end of method printEvaluation

	/**
	 * Users write their evaluation about our application.
	 *
	 * @throws IOException if an I/O error occurs
	 */
	public void reasonOfEvaluation() throws IOException {

		DataOutputStream outStream = cl.getOutStream();
		Inputs inp = new Inputs();

		System.out.println("Προσθέστε τα σχόλιά σας για την "
				+ "εφαρμογή StopSpread;");

		String sxolia = inp.stringScanner();
		System.out.println("Είστε σίγουροι οτι θέλετε να δώσετε "
				+ "αυτο το σχόλιο :\n "+ sxolia + "\n 1.Ναι \n 2.Όχι");
		int ans = inp.rangeInt(1,2);
		if (ans == 1 ) {
			System.out.println("Το σχόλιο στέλνεται αυτή την στιγμή");
		} else {
			System.out.println("Δοκιμάστε ξανά.");
			return;
		}
		outStream.writeUTF(sxolia);
		outStream.flush();
		System.out.println("Σας ευχαριστούμε, η κριτική σας "
				+ "μόλις καταχωρήθηκε!");

	} //end of method reasonOfEvaluation

	/**
	 * Shows other users' comments of the application.
	 *
	 * @throws IOException if an I/O error occurs
	 */
	public void showComments() throws IOException {

		// server-client messages
		DataInputStream inStream = cl.getInStream();

		String comment = inStream.readUTF(); // A random comment from server

		System.out.println("Ενας χρήστης έγραψε :");
		System.out.println();
		System.out.println(comment);

	} // end of method showComments

} //ending of Class InsertingEvaluation
