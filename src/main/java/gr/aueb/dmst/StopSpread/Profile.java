package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author alexd
 *	
 */
public class Profile {

	
	/** Authenticates user's credentials  
	 * @return user_id 
	* for later use in the program*/
	public static int authenticate() {		
		int user_id = 0;
		try {
			//server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
	        String clientMessage;
			String serverMessage;
			
			//for option identification 
			clientMessage = "login";
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας:");
			
			do {
			String name = Inputs.stringScanner();
			
			//sent user name to server
			clientMessage = name;
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			serverMessage = inStream.readUTF();
			System.out.println(serverMessage);
			}while (!serverMessage.equals("Αποδεκτό Ονομα Χρήστη"));
			
			
			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");
			
			do {
				String pass = Inputs.stringScanner();
	
				clientMessage = pass;
				outStream.writeUTF(clientMessage);
				outStream.flush();
				
				serverMessage = inStream.readUTF();
				System.out.println(serverMessage);
			}while (!serverMessage.equals("Αποδεκτός Κωδικός Χρήστη"));
			
			
			System.out.println("Επιτυχία Συνδεσης! ");
	
			
			
			user_id = inStream.readInt();
			
		}catch (IOException e) {
			System.err.println("Αποτυχία κατα την σύνδεση");
			e.printStackTrace();
		}
							
		return user_id;
	}

	/**Creates new user */
	public static void newEntry() {
		try {
			//server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
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
			}while(!serverMessage.equals("Αποδεκτό Ονομα Χρήστη"));

			
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
	
	/**
	 * Inserts new user location in the database 
	 * 
	 * @param user_id 
	 */
	public static void newLocation(int user_id) {
		
		System.out.println("Παρακαλούμε εισάγετε τα στοιχεία της τοποθεσίας που επισκευθήκατε :");
        System.out.println("Εισάγετε την πόλη :");
        String city = Inputs.stringScanner();
        
        System.out.println("Εισάγετε την διεύθηνση :");
        String address = Inputs.stringScanner();
        
        System.out.println("Εισάγετε την ώρα άφιξης, στρογγυλοποιημένη στον προηγούμενο ακέραιο :");
        int arr_time = Inputs.rangeInt(1,24);
        
        System.out.println("Εισάγετε την ώρα αναχώρησης, στρογγυλοποιημένη στον επόμενο ακέραιο :");
        int dep_time = Inputs.rangeInt(1,24);
        
        while (dep_time <= arr_time) {
        	System.err.println("Παρακαλούμε εισάγετε ώρα μεγαλύτερη απο την ώρα άφιξης :");
            dep_time = Inputs.rangeInt(1,24);
        }
        
        System.out.println("Εισάγετε την ημερομηνία της επίσεψής σας (ΥΥΥΥ-MM-DD) :");
        String date = Inputs.stringScanner();
        
        
        try {
	        //server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
	        String clientMessage;
			String serverMessage;
			
			//for option identification 
			clientMessage = "a epilogi";
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			//pass city to server 
			clientMessage= city;
            outStream.writeUTF(clientMessage);
            outStream.flush();
            
			//pass address to server 
            clientMessage= address;
            outStream.writeUTF(clientMessage);
            outStream.flush();
            
			//pass arr_time to server
            outStream.writeInt(arr_time);
            outStream.flush();
      
			//pass dep_time to server
            outStream.writeInt(dep_time);
            outStream.flush();
            
			//pass date to server
            clientMessage= date;
            outStream.writeUTF(clientMessage);
            outStream.flush();
   
			//pass user_id to server
            outStream.writeInt(user_id);
            outStream.flush();
            
            //message from server
            serverMessage = inStream.readUTF();
            System.out.println(serverMessage);
            
        }catch (IOException e) {
        	System.err.println("Πρόβλημα κατα την προσθήκη νέας τοποθεσίας");
        	e.printStackTrace();
        }
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
		
}
