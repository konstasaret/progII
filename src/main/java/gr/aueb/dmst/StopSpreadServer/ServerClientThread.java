package gr.aueb.dmst.StopSpreadServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class ServerClientThread extends Thread {

	/**Socket that server accepts*/
	private Socket socket;
	/**Client number since server started*/
	private int clientNo;
	/**Database object that contains the Connection*/
	private Database db;

	public ServerClientThread(Socket inSocket, int counter, Database db) {
		this.socket = inSocket;
		this.clientNo = counter;
		this.db = db;
	}

	@Override
	public void run() {


		try {

			// initializes input and output streams
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

			String clientMessage, serverMessage;
			int count = -5;// initializes count

			// option identification
			while (count != 0) {
				clientMessage = inStream.readUTF();
				if (clientMessage.equals("check")) {
					// connections check
					count = -3;
				} else if (clientMessage.equals("newuser")) {
					// new user
					count = -2;
				} else if (clientMessage.equals("login")) {
					// log in
					count = -1;
				} else if (clientMessage.equals("newLocation")) {
					// new location
					count = 1;
				} else if (clientMessage.equals("infected")) {
					// positive
					count = 2;
				} else if (clientMessage.equals("deleteUser")) {
					// deletes user
					count = 3;
				} else if (clientMessage.equals("seeLocations")) {
					// shows locations
					count = 4;
				} else if (clientMessage.equals("story")) {
					// stories
					count = 5;
				} else if (clientMessage.equals("eval")) {
					// evaluation
					count = 6;
				} else if (clientMessage.equals("deleteLocation")) {
					// deletes location
					count = 7;
				} // end of if



				// Options
				if (count == -3) {
					// connections check
					int user_id = inStream.readInt(); // gets user's id
					boolean infected = db.checkInfected(user_id);

					outStream.writeBoolean(infected); // passes infected
					outStream.flush();

					if (infected == true) {
						db.restoreInfected(user_id); // restores table
					}
				} else if (count == -2) {
					// new user
					String userName = inStream.readUTF(); // user's name from client

					// checks for duplicate users name
					while (db.usernameCheck(userName)) {
						serverMessage = "Το Όνομα Χρήστη χρησιμοποιείται ήδη. "
								+ "\nΠαρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη: ";
						outStream.writeUTF(serverMessage);
						outStream.flush();

						userName = inStream.readUTF(); // new user's name
					}

					// check done
					serverMessage = "Αποδεκτό Ονομα Χρήστη";
					outStream.writeUTF(serverMessage);
					outStream.flush();

					// password from client
					String pass = inStream.readUTF();

					// Insertion in table
					db.insertIntoUserTable(userName, pass);

				} else if (count == -1) {
					// log in
					String userName = inStream.readUTF(); // user's name from client

					// user's name exists check
					int user_id = db.findUsersId(userName);
					while (user_id == -1) {
						serverMessage = "Αποτυχία Σύνδεσης.\nΤο Όνομα Χρήστη δεν υπάρχει."
								+ "\nΠαρακαλώ προσπαθήστε ξανά : ";
						outStream.writeUTF(serverMessage);
						outStream.flush();

						userName = inStream.readUTF();
						user_id = db.findUsersId(userName);
					}
					// check done
					serverMessage = "Αποδεκτό Όνομα Χρήστη";
					outStream.writeUTF(serverMessage);
					outStream.flush();

					String pass = inStream.readUTF(); // password from client
					String existingPass = db.findUsersPass(user_id); // password from database

					// password check
					while (!existingPass.equals(pass)) {
						serverMessage = "Αποτυχία Συνδεσης.\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν."
								+ "\nΔοκιμάστε ξανά.\nΠαρακαλώ εισάγετε ξανά τον Κωδικό σας:";
						outStream.writeUTF(serverMessage);
						outStream.flush();

						pass = inStream.readUTF(); // new password
					}
					// check done
					serverMessage = "Αποδεκτός Κωδικός Χρήστη";
					outStream.writeUTF(serverMessage);
					outStream.flush();

					outStream.writeInt(user_id); // returns user's id
					outStream.flush();

				} else if (count == 1) {
					// new location
					String city = inStream.readUTF();
					String address = inStream.readUTF();
					int arrival_time = inStream.readInt();
					int departure_time = inStream.readInt();
					String date = inStream.readUTF();
					int user_id = inStream.readInt();

					db.insertIntoLocationsTable(city, address, arrival_time, departure_time, date, user_id);


				} else if (count == 2) {
					// infected
					int user_id = inStream.readInt();
					db.findConnections(user_id);
					serverMessage = "Ευχαριστούμε για την ενημέρωση\n"
							+ "Θα ειδοποιήσουμε τις πιθανές επαφές σας\n Κατευθυνθείτε προς το πλησιέστερο νοσοκομείο";
					outStream.writeUTF(serverMessage);
					outStream.flush();

				} else if (count == 3) {
					// delete user
					int user_id = inStream.readInt(); // gets user's id from client
					String given_pass = inStream.readUTF(); // gets user's input password from client
					String exist_pass = db.findUsersPass(user_id); // user's password

					// password check
					while (!given_pass.equals(exist_pass)) {
						serverMessage = "Ο κωδικός σας δεν ταιριάζει \nΠαρακαλώ δωκιμάστε ξανά :";
						outStream.writeUTF(serverMessage);
						outStream.flush();
						given_pass = inStream.readUTF();
					}

					// check done
					serverMessage = "Αποδεκτός Κωδικός Χρήστη";
					outStream.writeUTF(serverMessage);
					outStream.flush();
					db.deleteUsersRow(user_id);

				} else if (count == 4) {
					// see locations
					int user_id = inStream.readInt(); // gets user's id from client
					ResultSet results = db.userLocationsResult(user_id); // gets data

					try {
						// An object that can be used to get information about the types and properties
						// of the columns in a ResultSet object
						ResultSetMetaData rsmd = results.getMetaData();

						int numberCols = rsmd.getColumnCount() - 1; // gets number of columns -1 to exclude user_id
						outStream.writeInt(numberCols); // sends to client
						outStream.flush();

						// sends column names
						for (int i = 1; i <= numberCols; i++) {
							outStream.writeUTF(rsmd.getColumnLabel(i));
						} // end of for

						while (results.next()) {
							outStream.writeUTF("more"); // checks message
							outStream.flush();

							outStream.writeUTF(results.getString(1)); // city
							outStream.flush();
							outStream.writeUTF(results.getString(2)); // address
							outStream.flush();
							outStream.writeInt(results.getInt(3)); // arrival time
							outStream.flush();
							outStream.writeInt(results.getInt(4)); // departure time
							outStream.flush();
							outStream.writeUTF(results.getString(5)); // date
							outStream.flush();
						}
						outStream.writeUTF("ok");// checks message
						outStream.flush();
						results.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				} else if (count == 5) {
					clientMessage = inStream.readUTF();
					int option = 0;
					if (clientMessage.equals("read story")) {
						option = 1;
					} else if (clientMessage.equals("new story")) {
						option = 2;
					} else if (clientMessage.equals("exit")) {
						// will do nothing
					} // end of if

					if (option == 1) {
						ResultSet results = db.getRandomStory();
						try {
							results.next();

							outStream.writeUTF(results.getString(2));
							outStream.flush();

							outStream.writeUTF(results.getString(3));
							outStream.flush();

							results.close();

						} catch (SQLException e) {
							e.printStackTrace();
						}

					} else if (option == 2) {
						String storyTitle = inStream.readUTF();
						String storyBody = inStream.readUTF();
						db.insertIntoStoriesTable(storyTitle, storyBody);
					}

				} else if (count == 6) {
					clientMessage = inStream.readUTF();
					int option = 0;

					if (clientMessage.equals("eval01")) {
						option = 1;
					} else if (clientMessage.equals("eval02")) {
						option = 2;
					} else if (clientMessage.equals("eval03")) {
						option = 3;
					} else if (clientMessage.equals("eval04")) {
						option = 4;
					} else if (clientMessage.equals("eval05")) {
						// will do nothing
					} // end of if

					if (option == 1) {
						int[] Ev = db.getEvaluations();

						outStream.writeInt(Ev[0]);
						outStream.flush();
						outStream.writeInt(Ev[1]);
						outStream.flush();
						outStream.writeInt(Ev[2]);
						outStream.flush();
						outStream.writeInt(Ev[3]);
						outStream.flush();
						outStream.writeInt(Ev[4]);
						outStream.flush();
					} else if (option == 2) {
						int idToVote = inStream.readInt();

						int idVoted = db.findUserIdForVote(idToVote);
						outStream.writeInt(idVoted);
						outStream.flush();
						if (idVoted == -1) { // user has not voted again
							db.insterIntoIdsWhoVoted(idToVote);
							int choice = inStream.readInt();
							db.insertIntoEvaluationTable(choice);
						}
					} else if (option == 3) {

						String sxolioXristi = inStream.readUTF();
						db.instertEvalComments(sxolioXristi);

					} else if (option == 4) {

						String comment = db.findRandomComment();
						outStream.writeUTF(comment);
						outStream.flush();

					} // end of if

				} else if (count == 7) {
					//delete location

					String City = inStream.readUTF(); // Get City
					String Address = inStream.readUTF(); // Get Address
					int arrival_time = inStream.readInt(); // Get arrival_time
					int departure_time = inStream.readInt(); // Get departure_time
					String date = inStream.readUTF(); // Get date
					int user_id = inStream.readInt(); // Get user_id

					if (db.deleteLocationsRow(City, Address,
							arrival_time, departure_time, date, user_id)) {
						outStream.writeUTF("exists");
						outStream.flush();
					}else {
						outStream.writeUTF("notExists");
						outStream.flush();
					}

				} // end of if
			} // end of while

			inStream.close();
			outStream.close();
			socket.close();

		} catch (IOException e) {
			System.err.println("Client -" + clientNo + " exit!! ");
		} finally {
			System.out.println("Connection reset waiting for new Client");
		} // end of try-catch

	} // end of method run

} // end of Class ServerClientThread
