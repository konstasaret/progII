package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Date;

/**
 * Creates the user's profile they if don't have an account, otherwise verifies
 * user's given data and connects with our application.
 *
 * Connection with data base to store the user's data like user_name, password
 * location, date and so on. Data like location can be deleted.
 */
public class Profile {

	/** Object used to get the DataInputStream and DataOutputStream */
	private TCPClient cl = new TCPClient();

	/**
	 * Authenticates user's credentials.
	 *
	 * @return user_id for later use in the program.
	 */
	public int authenticate() {

		Inputs inp = new Inputs();

		int user_id = 0;
		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;
			String serverMessage;

			// for option identification
			clientMessage = "login";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας:");

			do {
				String name = inp.stringScanner();

				// sends user name to server
				clientMessage = name;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			} while (!serverMessage.equals("Αποδεκτό Όνομα Χρήστη"));

			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");

			do {
				String pass = inp.stringScanner();

				clientMessage = pass;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			} while (!serverMessage.equals("Αποδεκτός Κωδικός Χρήστη"));

			System.out.println("Επιτυχία Συνδεσης!");

			user_id = inStream.readInt();

		} catch (IOException e) {
			System.err.println("Αποτυχία κατά τη σύνδεση");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		}

		return user_id;
	} // end of method authenticate

	/** Creates new user. */
	public void newEntry() {
		Inputs inp = new Inputs();

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;
			String serverMessage;

			// for option identification
			clientMessage = "newuser";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			System.out.println("Παρακαλώ εισάγετε Όνομα Χρήστη:");
			do {
				String user_name = inp.stringScanner(); // Desired user name

				// sends to server
				clientMessage = user_name;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// server check message
				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			} while (!serverMessage.equals("Αποδεκτό Όνομα Χρήστη"));

			String pass, pass2;
			do {
				// users desired password
				System.out.println("Παρακαλώ εισάγετε Κωδικό Χρήστη:");
				pass = inp.stringScanner();
				// strong password check
				while (pass.equals(pass.toLowerCase()) // one upper case
						|| pass.equals(pass.toUpperCase()) // one lower case
						|| pass.length() < 8 // at least 8 chars
						|| !pass.matches(".*\\d.*")) { // at least one number
					System.err.println("Ο κωδικός θα πρέπει να αποτελείται από τουλάχιστον "
							+ "8 χαρακτήρες και να περιέχει τουλάχιστον "
							+ "έναν αριθμό, ένα κεφαλαίο και ένα πεζό γράμμα.");
					System.out.println("Παρακαλώ εισάγετε διαφορετικό κωδικό");
					pass = inp.stringScanner();
				}

				// double check password
				System.out.println("Παρακαλώ επιβεβαιώστε τον Κωδικό Χρήστη σας:");
				pass2 = inp.stringScanner();
				if (!pass.equals(pass2)) {
					System.out.println("Οι Κωδικοί Χρήστη σας δεν ταιριάζουν.\nΔοκιμάστε Ξανά.");
				}
			} while (!pass.equals(pass2));

			// sends password to server
			clientMessage = pass;
			outStream.writeUTF(clientMessage);
			outStream.flush();

			System.out.println("Ο Λογαριασμός σας δημιουργήθηκε με επιτυχία!");
			System.out.println("Συνδεθείτε για να ανακαλύψετε τις δυνατότητες!"); // SON

		} catch (IOException e) {
			System.err.println("Αποτυχία δημιουργίας νέου χρήστη");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		}
	}

	/**
	 * Is called every time a user is logged in the application. Warns him if
	 * someone infected has been in the same locations as him the past 14 days.
	 *
	 * @param user_id is the user's id
	 */
	public void checkConnections(int user_id) {

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;

			// for option identification
			clientMessage = "check";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			// passes user id to server
			outStream.writeInt(user_id);
			outStream.flush();

			boolean infected = inStream.readBoolean();

			if (infected == true) {
				System.out.println("***********************************");
				System.out.println("Έχετε έρθει σε επαφή με κρούσμα. \nΠηγαίνετε στο πλησιέστερο νοσοκομείο");
				System.out.println("***********************************");

				// Show nearest hospitals
				String url = "https://www.google.com/maps/search/hospital";
				Url.openUrl(url);
			}

		} catch (IOException e) {
			System.out.println("Πρόβλημα κατά τον έλεγχο των επαφών");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		} // end of catch
	}// end of method checkConnections

	/**
	 * Inserts new user location in the database.
	 *
	 * @param user_id is the user's id
	 */
	public void newLocation(int user_id) {
		Inputs inp = new Inputs();

		System.out.println("Παρακαλούμε εισάγετε τα στοιχεία της τοποθεσίας που "
				+ "επισκεφτήκατε με κεφαλαία γράμματα και χωρίς τόνους:");

		System.out.println("Εισάγετε την πόλη: ");
		String city = inp.stringScanner();
		while (!city.matches("^\\p{InGreek}\\p{javaUpperCase}+$")) {
			System.err.println("Παρακαλώ εισάγετε την πόλη με κεφαλαία ελληνικά γράμματα: ");
			city = inp.stringScanner();
		}

		System.out.println("Εισάγετε τη διεύθυνση και αριθμό:");
		String address = inp.stringScanner();
		while (!address.matches("^[\\p{InGreek}\\p{javaUpperCase}\\s\\.]*\\s[0-9]*$")) {
			System.err.println("Παρακαλώ εισάγετε διεύθυνση και αριθμό με κεφαλαία ελληνικά γράμματα");
			address = inp.stringScanner();
		}

		System.out.println(
				"Εισάγετε την ώρα άφιξης, σε εικοσιτετράωρη βάση, στρογγυλοποιημένη στον προηγούμενο ακέραιο:");
		int arr_time = inp.rangeInt(0, 23);

		System.out.println(
				"Εισάγετε την ώρα αναχώρησης, σε εικοσιτετράωρη βάση, στρογγυλοποιημένη στον επόμενο ακέραιο:");
		int dep_time = inp.rangeInt(1, 24);
		while (dep_time <= arr_time) {
			System.err.println("Παρακαλούμε εισάγετε ώρα μεγαλύτερη από την ώρα άφιξης:");
			dep_time = inp.rangeInt(1, 24);
		}

		System.out.println("Εισάγετε την ημερομηνία της επίσκεψής σας (ΕΕΕΕ-ΜΜ-ΗΗ):");
		String date = inp.stringScanner();

		// The current date
		String currentDate = String.valueOf(new Date(System.currentTimeMillis()));

		// regex does not find leap years all February go up to 29
		while (!date.matches("^[0-9]{4}-(" // Year
				+ "((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))" // 31 days months
				+ "|(02-(0[1-9]|[1-2][0-9]))|" // February
				+ "((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$") // 30 days months
				|| date.compareTo(currentDate) > 0) { // date is in future
			System.err.println("Παρακαλώ εισάγετε μία έγκυρη ημερομηνία στην εξής μορφή (ΕΕΕΕ-ΜΜ-ΗΗ) :");
			date = inp.stringScanner();
		}

		System.out.println("Είναι αυτή η σωστή τοποθεσία σας; (ΝΑΙ/ΟΧΙ)" + "\n	Πόλη: " + city + "\n	Διεύθυνση: "
				+ address + "\n	Άφιξη: " + arr_time + ":00" + "\n	Αναχώριση: " + dep_time + ":00 "
				+ "\n	Ημερομηνία: " + date);

		String yesORno = inp.stringScanner();
		while (!(yesORno.equals("ΝΑΙ") || yesORno.equals("ΟΧΙ"))) { // ΝΑΙ and ΟΧΙ are in Greek characters
			System.out.println("Παρακαλώ πληκτρολογήστε 'ΝΑΙ' ή 'ΟΧΙ'");
			yesORno = inp.stringScanner();
		}

		if (yesORno.equals("ΝΑΙ")) {
			try {
				// server-client messages
				DataOutputStream outStream = cl.getOutStream();
				String clientMessage;

				// for option identification
				clientMessage = "newLocation";
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// passes city to server
				clientMessage = city;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// passes address to server
				clientMessage = address;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// passes arr_time to server
				outStream.writeInt(arr_time);
				outStream.flush();

				// passes dep_time to server
				outStream.writeInt(dep_time);
				outStream.flush();

				// passes date to server
				clientMessage = date;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// passes user_id to server
				outStream.writeInt(user_id);
				outStream.flush();

			} catch (IOException e) {
				System.err.println("Πρόβλημα κατά την προσθήκη νέας τοποθεσίας");
				System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
						+ "Παρακαλούμε δοκιμάστε αργότερα.");
				return;
			} // end of catch

			System.out.println("Η τοποθεσία σας καταγράφηκε");
		} else {
			System.out.println("Δοκιμάστε ξανά");

		} // end of if
	} // end of method newLocation

	/**
	 * Method is called when user is infected and warns other users who have been in
	 * the same location the past 14 days.
	 *
	 * @param user_id is the user's id
	 */
	public void infected(int user_id) {

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;
			String serverMessage;

			// for option identification
			clientMessage = "infected";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			// passes user id to server
			outStream.writeInt(user_id);
			outStream.flush();

			serverMessage = inStream.readUTF();
			System.out.println(serverMessage);

		} catch (IOException e) {
			System.err.println("Πρόβλημα κατά την επιλογή κόλλησα κορονοϊό");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		} // end of catch
	} // end of method infected

	/**
	 * Prints user locations based on user id.
	 *
	 * @param user_id is the id of the user
	 */
	public void seeLocations(int user_id) {

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;

			// for option identification
			clientMessage = "seeLocations";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			outStream.writeInt(user_id);// sends id to server
			outStream.flush();

			int numCols = inStream.readInt();// gets number of columns

			// output format
			System.out.println("------------------------------" + "--------------------------------------"
					+ "------------------------------------------");

			for (int i = 1; i <= numCols; i++) {
				// prints column Names
				System.out.printf("%-25s", inStream.readUTF());
			} // end of for

			System.out.println("\n--------------------------" + "------------------------------------------"
					+ "------------------------------------------");

			// prints rows
			while (!inStream.readUTF().equals("ok")) {
				String City = inStream.readUTF();
				String Address = inStream.readUTF();
				int arrival_time = inStream.readInt();
				int departure_time = inStream.readInt();
				String date = inStream.readUTF();

				System.out.printf("%-25s%-25s%-25s%-25s%-25s%n", City, Address, arrival_time, departure_time, date);
			}
		} catch (IOException e) {
			System.err.println("Πρόβλημα κατά την εμφάνιση τοποθεσιών");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		}

	} // end of method seeLocations

	/**
	 * Deletes a user's location from database.
	 *
	 * @param user_id is the id of the user
	 */
	public void deleteLocation(int user_id) {

		System.out.println("Οι τοποθεσίες σας είναι:");
		// allows user to see his locations again
		Profile prof = new Profile();
		prof.seeLocations(user_id);

		Inputs inp = new Inputs(); // Scanner
		String[] split_location; // Array to store location components

		System.out.println("Παρακαλώ αντιγράψτε την τοποθεσία που επιθυμείτε να διαγράψετε.");
		// reads the location he wants to delete
		String read_location = inp.stringScanner();

		// gets components of the location separated with any number of spaces
		split_location = read_location.split("\\s\\s+");

		while (!(split_location.length == 5)) {
			System.out.println("Ουπς! Μάλλον έγινε λάθος κατά την επικόλληση. \nΔοκιμάστε ξανά:");

			// reads the location he wants to delete again
			read_location = inp.stringScanner();

			// gets components of the location separated
			// with any number of spaces
			split_location = read_location.split("\\s\\s+");
		}

		// make sure he wants to delete this location
		System.out.println("Είναι αυτή η τοποθεσία που θέλετε να διαγράψετε; (ΝΑΙ/ΟΧΙ)");
		System.out.printf("%-18s%-18s%-18s%-18s%-18s%n", split_location[0], split_location[1], split_location[2],
				split_location[3], split_location[4]);

		String yesORno = inp.stringScanner();
		while (!(yesORno.equals("ΝΑΙ") || yesORno.equals("ΟΧΙ"))) {
			System.out.println("Παρακαλώ πληκτρολογήστε 'ΝΑΙ' ή 'ΟΧΙ'");
			yesORno = inp.stringScanner();
		}

		if (yesORno.equals("ΟΧΙ")) {
			System.out.println("Δοκιμάστε ξανά:");
			deleteLocation(user_id);
			return;
		}

		// try to convert into int
		// NumberFormatException means that the data are not correct
		try {
			Integer.valueOf(split_location[2]);
			Integer.valueOf(split_location[3]);
		} catch (NumberFormatException e) {
			System.err.println("Τα στοιχεία της τοποθεσίας δεν ήταν σωστά");
			return;
		}

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;

			// for option identification
			clientMessage = "deleteLocation";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			// passes City
			outStream.writeUTF(split_location[0]);
			outStream.flush();

			// passes Address
			outStream.writeUTF(split_location[1]);
			outStream.flush();

			// passes arrival_time
			outStream.writeInt(Integer.valueOf(split_location[2]));
			outStream.flush();

			// passes departure_time
			outStream.writeInt(Integer.valueOf(split_location[3]));
			outStream.flush();

			// passes date
			outStream.writeUTF(split_location[4]);
			outStream.flush();

			// passes user_id
			outStream.writeInt(user_id);
			outStream.flush();

			if (inStream.readUTF().equals("exists")) {
				System.out.println("Η τοποθεσία σας διαγράφηκε με επιτυχία.");
			} else {
				System.out.println("Η τοποθεσία σας δε βρέθηκε. \nΔοκιμάστε ξανά");
			}

		} catch (IOException e) {
			System.err.println("Πρόβλημα κατά τη διαγραφή τοποθεσίας");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		}
	} // end of method deleteLocation

	/**
	 * Double checks user's credentials and deletes users data.
	 *
	 * @param user_id is the id of the user
	 */
	public void deleteUser(int user_id) {
		Inputs inp = new Inputs();

		try {
			// server-client messages
			DataOutputStream outStream = cl.getOutStream();
			DataInputStream inStream = cl.getInStream();
			String clientMessage;
			String serverMessage;

			// for option identification
			clientMessage = "deleteUser";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			// passes user id to server
			outStream.writeInt(user_id);
			outStream.flush();

			// double check user's credentials
			System.out.println("Παρακαλώ εισάγετε ξανά τον κωδικό σας :");
			do {
				String given_pass = inp.stringScanner();

				clientMessage = given_pass;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			} while (!serverMessage.equals("Αποδεκτός Κωδικός Χρήστη"));

			System.out.println("Επιτυχία διαγραφής στοιχείων");

		} catch (IOException e) { // end of try and beginning of catch block
			System.err.println("Πρόβλημα κατά τη διαγραφή χρήστη");
			System.err.println("Η σύνδεση με το διακομιστή απέτυχε.\n"
					+ "Παρακαλούμε δοκιμάστε αργότερα.");
		} // end of catch block
	} // end of method deleteUser

} // end of Class Profile
