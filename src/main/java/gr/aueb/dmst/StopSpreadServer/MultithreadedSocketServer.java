package gr.aueb.dmst.StopSpreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Starting server Class.
 */
public class MultithreadedSocketServer {

	/**
	 * Starts the Server
	 *
	 * @param args no use
	 */
	public static void main(String[] args) {

		// Database object that will contain the Connection
		Database db = null;

		try {
			// initialize server socket
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(8888);

			// number of threads
			int counter = 0;

			System.out.println("Server Started ....");

			// create the Connection for all clients
			db = new Database();

			while (true) {
				counter++;
				Socket serverClient = server.accept(); // server accept the client connection request
				System.out.println(">> " + "Client No:" + counter + " started!");

				// send the request to a separate thread
				ServerClientThread sct = new ServerClientThread(serverClient, counter, db);
				// start the thread
				sct.start();
			} // end of while
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			db.shutdownConnection();
		}// end of try-catch

	} // end of main

} // end of class
