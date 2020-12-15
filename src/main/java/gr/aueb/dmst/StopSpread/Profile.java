package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author AirlineDog
 *	
 */
public class Profile {

	
	/** Authenticates user's credentials  
	 * @return user_id 
	* for later use in the program*/
	public int authenticate() {		
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
	public void newEntry() {
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
				//strong password check
				while (pass.equals(pass.toLowerCase()) //one upper case
						|| pass.equals(pass.toUpperCase()) //one lower case
						|| pass.length() < 8 //at least 8 chars
						|| !pass.matches(".*\\d.*")) { // at least one number
					System.err.println("Ο κωδικός θα πρέπει να αποτελείται απο τουλάχιστον 8 χαρακτήρες και να περιέχει απο τουλάχιστον έναν αριθμό, ένα κεφαλαίο και ένα πεζό γράμμα");
					System.out.println("Παρακαλώ εισάγετε διαφορετικό κωδικό");
					pass = Inputs.stringScanner();
				}
				
				
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
	 * Called every time a user is logged in the app
	 * Warns him if someone infected has been in the same locations as him the past 14 days
	 * @param user_id
	 */
	public void checkConnections(int user_id) {
		try{
		//server-client messages
        DataOutputStream outStream = TCPClient.getOutStream();
        DataInputStream inStream = TCPClient.getInStream();
        String clientMessage;
		
		//for option identification 
		clientMessage = "check";
		outStream.writeUTF(clientMessage);
		outStream.flush();
		
		//pass user id to server
		outStream.writeInt(user_id);
		outStream.flush();
		
		boolean infected = inStream.readBoolean();
		
		if (infected == true) {
			System.out.println("***********************************");
			System.out.println("Εχετε έρθει σε επαφή με κρούσμα \n"
				+ "Πηγένετε στο πλησιέστερο νοσοκομείο");
			System.out.println("***********************************");
		}
		}catch(IOException e) {
			System.out.println("Πρόβλημα κατά τον έλεγχο των επαφών");
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserts new user location in the database 
	 * 
	 * @param user_id 
	 */
	public void newLocation(int user_id) {
		
		System.out.println("Παρακαλούμε εισάγετε τα στοιχεία της τοποθεσίας που επισκευθήκατε με κεφαλάια γράμματα και χωρίς τόνους:");
		
        System.out.println("Εισάγετε την πόλη :");
        String city = Inputs.stringScanner();
        while (!city.equals(city.toUpperCase())) {
        	System.err.println("Παρακαλώ εισάγετε τα στοιχεία σας με κεφαλάια γράμματα");
            city = Inputs.stringScanner();
        }
        
        System.out.println("Εισάγετε την διεύθυνση :");
        String address = Inputs.stringScanner();
        while (!address.equals(address.toUpperCase())) {
        	System.err.println("Παρακαλώ εισάγετε τα στοιχεία σας με κεφαλάια γράμματα");
            address = Inputs.stringScanner();
        }
        
        System.out.println("Εισάγετε την ώρα άφιξης, σε εικοσιτετράωρη βάση, στρογγυλοποιημένη στον προηγούμενο ακέραιο :");
        int arr_time = Inputs.rangeInt(1,24);
        
        System.out.println("Εισάγετε την ώρα αναχώρησης, σε εικοσιτετράωρη βάση, στρογγυλοποιημένη στον επόμενο ακέραιο :");
        int dep_time = Inputs.rangeInt(1,24);
        while (dep_time <= arr_time) {
        	System.err.println("Παρακαλούμε εισάγετε ώρα μεγαλύτερη απο την ώρα άφιξης :");
            dep_time = Inputs.rangeInt(1,24);
        }
        
        System.out.println("Εισάγετε την ημερομηνία της επίσεψής σας (ΕΕΕΕ-ΜΜ-ΗΗ) :");
        String date = Inputs.stringScanner();
        while (!date.matches("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$")) {
        	System.err.println("Παρακαλώ εισάγεται την ημερομηνία στην εξής μορφή (ΕΕΕΕ-ΜΜ-ΗΗ) :");
        	date = Inputs.stringScanner();
        }
        
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
	 * Called when user is infected
	 * Warns other users that have been in the same location the past 14 days
	 * @param user_id
	 */
	public void infected(int user_id) {
		try {
			//server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
	        String clientMessage;
			String serverMessage;
			
			//for option identification 
			clientMessage = "b epilogi";
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			//pass user id to server
			outStream.writeInt(user_id);
			outStream.flush();
			
			serverMessage = inStream.readUTF();
			System.out.println(serverMessage);
		}catch (IOException e) {
			System.out.println("Πρόβλημα κατα την επιλογή κόλλησα κορονοϊό");
			e.printStackTrace();
		}
	}

	/**
	 * Double checks user's credentials and deletes users data
	 * @param user_id
	 */
	public void deleteUser(int user_id) {
		try {
			//server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
	        String clientMessage;
			String serverMessage;
			
			//for option identification 
			clientMessage = "c epilogi";
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			//pass user id to server
			outStream.writeInt(user_id);
			outStream.flush();
			
			//double check user's credentials
			System.out.println("Παρακαλώ εισάγεται ξανά τον κωδικό σας :");
			do {
			String given_pass = Inputs.stringScanner();
			
			clientMessage = given_pass;
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			serverMessage = inStream.readUTF();
			System.out.println(serverMessage);
			}while (!serverMessage.equals("Αποδεκτός Κωδικός Χρήστη"));
			
			System.out.println("Επιτυχία διαγραφής στοιχείων");

		}catch (IOException e) {
			System.err.println("Προβλημα κατα την διαγραφή χρήστη");
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints user locations based in user id
	 * @param user_id
	 */
	public void seeLocations(int user_id) {
		
		try {
			//server-client messages
	        DataOutputStream outStream = TCPClient.getOutStream();
	        DataInputStream inStream = TCPClient.getInStream();
	        String clientMessage;
			
			//for option identification 
			clientMessage = "d epilogi";
			outStream.writeUTF(clientMessage);
			outStream.flush();
			
			outStream.writeInt(user_id);
			outStream.flush();
			
			int numCols = inStream.readInt();//get number of columns
			
			//output format
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            
            for (int i=1; i<=numCols; i++) {
             //print Column Names
                System.out.printf("%-18s", inStream.readUTF());  
            }//end of for

            System.out.println("\n-------------------------------------------------------------------------------------------------");

            //print rows
            while(!inStream.readUTF().equals("ok")) {
            	  String City = inStream.readUTF();
                  String Address = inStream.readUTF();
                  int arrival_time = inStream.readInt();
                  int departure_time = inStream.readInt();
                  String date = inStream.readUTF();
                  
                  System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",City , Address , arrival_time, departure_time ,date);
            }
		} catch (IOException e) {
			System.err.println("Προβλημα κατά την εμφάνιση τοποθεσιών");
			e.printStackTrace();
		}
		
	}


		
}
