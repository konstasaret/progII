package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Client Class
 *
 */
public class TCPClient {

	/** Socket to be used */
	private static Socket socket;
	/** Takes data from Server */
	private static DataInputStream inStream;
	/** Receives data from Server */
	private static DataOutputStream outStream;

	/**
	 * @return the inStream
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
	 * Begins User's Interface
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {

		// Objects from always used classes
		Profile prof = new Profile();
		Menus menu = new Menus();
		Inputs inp = new Inputs();

		try {

			socket = new Socket("127.0.0.1", 8888);// Initialize socket

			inStream = new DataInputStream(socket.getInputStream());// Initialize DataInputStream
			outStream = new DataOutputStream(socket.getOutputStream());// Initialize DataOutputStream

			int user_id = 0;// Initialize user_id

			while (user_id == 0) {// Login while
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

			// Check for infected connections
			prof.checkConnections(user_id);

			while (true) {// endless loop that breaks when user sign out or delete account

				menu.firstMenu();
				int option = inp.rangeInt(1, 9);

				if (option == 1) {
					// New location
					prof.newLocation(user_id);
				} else if (option == 2) {
					// positive
					prof.infected(user_id);
				} else if (option == 3) {
					// see locations
					prof.seeLocations(user_id);
				} else if (option == 4) {
					// greek stats
					GSX g = new GSX();
					g.gsxToTCP();
				} else if (option == 5) {
					// global stats
					// TODO enter the stats
				} else if (option == 6) {
					// stories
					Stories st = new Stories();
					st.stories();
				} else if (option == 7) {
					// evaluation
					// TODO enter evaluation
				} else if (option == 8) {
					// delete user
					prof.deleteUser(user_id);
					break;
				} else if (option == 9) {
					// sing out
					break;
				} // end of if

			} // end of while

			System.out.println("Λυπούμαστε που φεύγετε");

			outStream.close();
			outStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
