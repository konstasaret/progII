package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Client Class.
 */
public class TCPClient {

	/** Socket to be used. */
	private static Socket socket;
	/** Takes data from Server. */
	private static DataInputStream inStream;
	/** Receives data from Server. */
	private static DataOutputStream outStream;

	/**
	 * @return the inStream.
	 */
	public DataInputStream getInStream() {
		return inStream;
	}

	/**
	 * @return the outStream
	 */
	public DataOutputStream getOutStream() {
		return outStream;
	}

	/**
	 * Begins User's Interface.
	 *
	 * @param args is the parameter for main
	 *
	 */
	public static void main(String[] args) {

		// Objects from always used classes
		Profile prof = new Profile();
		Menus menu = new Menus();
		Inputs inp = new Inputs();
// TODO : clear random comments from database and add some sample
		try {

			// Initialize socket
			socket = new Socket("127.0.0.1", 8888);
			// Initialize DataInputStream
			inStream = new DataInputStream(socket.getInputStream());
			// Initialize DataOutputStream
			outStream = new DataOutputStream(socket.getOutputStream());

			int user_id = 0; // Initialize user_id

			while (user_id == 0) { // Login while
				menu.logInMenu();
				int logg = inp.rangeInt(1, 2);
				if (logg == 1) {
					// log in
					user_id = prof.authenticate();
				} else if (logg == 2) {
					// new user
					prof.newEntry();
				} // end of if
			} // end of while

			// Checks for infected connections
			prof.checkConnections(user_id);

			while (true) { // endless loop that breaks when user signs out or deletes account

				menu.firstMenu();
				int option = inp.rangeInt(1, 11);

				if (option == 1) {
					// New location
					prof.newLocation(user_id);
				} else if (option == 2) {
					// positive
					prof.infected(user_id);
				} else if (option == 3) {
					// shows locations
					prof.seeLocations(user_id);
				} else if (option == 4) {
					// Greek statistics
					GreekStats greek = new GreekStats();
					greek.greekStats();
				} else if (option == 5) {
					// global statistics
					GlobalStats global = new GlobalStats();
					global.globalStats();
				} else if (option == 6) {
					// stories
					Stories st = new Stories();
					st.stories();
				} else if (option == 7) {
					// frequent questions
					Fanswers f = new Fanswers();
					f.freqQuest();
				} else if (option == 8) {
					// deletes location
					prof.deleteLocation(user_id);
				} else if (option == 9) {
					// evaluation
					InsertingEvaluation eval = new InsertingEvaluation();
					eval.printMenuEval(user_id);
				} else if (option == 10) {
					// deletes user
					prof.deleteUser(user_id);
					break;
				} else if (option == 11) {
					// sing out
					break;
				} // end of if

			} // end of while

			System.out.println("Λυπούμαστε που φεύγετε.");

			outStream.close();
			outStream.close();
			socket.close();
		} catch (IOException e) {
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		}
	} // end of method main
} // end of Class TCPClient
