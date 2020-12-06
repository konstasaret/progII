package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author alexd
 *	
 */
public class Profile extends TCPClient {

	private static DataInputStream inStream;
	private static DataOutputStream outStream;
	
	
	/**Creates new user */
	public static void newEntry() {
		try {
			//server-client messages
	        outStream = new DataOutputStream(socket.getOutputStream());
	        inStream = new DataInputStream(socket.getInputStream());
	        String clientMessage;
			String serverMessage;
			
			//for option identification 
			clientMessage = "newuser";
			outStream.writeUTF(clientMessage);
			outStream.flush();

			System.out.println("Παρακαλώ εισάγετε Όνομα Χρήστη:");
			do {
				String user_name = Inputs.stringScanner();//Desired user name
				
				//sent to server
				clientMessage = user_name;
				outStream.writeUTF(clientMessage);
				outStream.flush();

				//server check message
				serverMessage=inStream.readUTF();
				System.out.println(serverMessage);
			}while(!serverMessage.equals("success"));

			
			String pass, pass2;
			do {
				//users desired password
				System.out.println("Παρακαλώ εισάγετε Κωδικό Χρήστη:");
				pass = Inputs.stringScanner();
				//double check password
				System.out.println("Παρακαλώ επιβεβαιώστε τον Κωδικό Χρήστη σας:");
				pass2 = Inputs.stringScanner();
				if(!pass.equals(pass2)) {
					System.out.println("Οι Κωδικοί Χρήστη σας δεν ταιριάζουν.\nΔοκιμάστε Ξανά."); // FIX THE DATA BASE TO WORK WHEN YOU TEST IT
				}
			}while(!pass.equals(pass2));

			//sent password to server
			clientMessage = pass;
			outStream.writeUTF(clientMessage);
			outStream.flush();

			System.out.println("Ο Λογαριασμός σας δημιουργήθηκε με επιτυχία!");
			System.out.println("Συνδεθείτε για να ανακαλύψετε τις δυνατότητες!"); // SON


		} catch (IOException e) {
			System.err.println("Αποτυχία δημιουργίας νέου χρήστη");
			e.printStackTrace();
		}
	}
	
	/** Authenticates user's credentials  
	 * @return user_id 
	* for later use in the program*/
	public static int authenticate() {		
			
		Database.createConnection();
			
		int user_id;
			
		System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας:");
		String name = Inputs.stringScanner();
			
		user_id = Database.findUsersId(name);
		while (user_id == -1) {
			System.out.println("Αποτυχία Σύνδεσης.\nΤο Όνομα Χρήστη δεν υπάρχει.\nΠαρακαλώ προσπαθήστε ξανά : ");
			name = Inputs.stringScanner();
			user_id = Database.findUsersId(name);
		}
			
			
		System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");
		String pass = Inputs.stringScanner();
			
		String existingPass = Database.findUsersPass(user_id);
			
		while(!existingPass.equals(pass)) {
			System.out.println("Αποτυχία Συνδεσης.\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν.\nΔοκιμάστε ξανά.");
			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");
			pass = Inputs.stringScanner();
		}

		System.out.println("Επιτυχία Συνδεσης! ");
			
		Database.shutdownConnection();
			
		return user_id;
	}

	/**
	 * Double checks user's credentials and deletes users data
	 * @param user_id
	 */
	public static void deleteUser(int user_id) {
		Database.createConnection();
		//double check user's credentials
		System.out.println("Παρακαλώ εισάγεται ξανά τον κωδικό σας :");
		String given_pass = Inputs.stringScanner();
		String exist_pass = Database.findUsersPass(user_id);
		while (!given_pass.equals(exist_pass)) {
			System.out.println("Ο κωδικός σας δεν ταιριάζει \nΠαρακαλώ δωκιμάστε ξανά :");
			given_pass = Inputs.stringScanner();
			exist_pass = Database.findUsersPass(user_id);
		}
		
		//deletion
		Database.deleteUsersRow(user_id);
		System.out.println("Επιτυχία διαχραφής στοιχείων");
		Database.shutdownConnection();
	}
	
	public static void seeLocations(int user_id) {
		Database.createConnection();
			
		Database.printUserLocations(user_id);
			
		Database.shutdownConnection();
	}

	public static void newLocation() {
					
	}
		
}
