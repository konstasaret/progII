package AirlineDog;

import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
	

	/**Creates new user */
	public static void newEntry() {
		Database.createConnection();		
		Scanner in = new Scanner(System.in);
				
				System.out.println("Παρακαλώ εισάγετε Όνομα Χρήστη");
				String user_name=in.nextLine();
				while (Database.usernameCheck(user_name)) {
					System.out.println("Το Όνομα Χρήστη χρησημοποιείται");
					System.out.println("Παρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη");
					user_name = in.nextLine();
				}
				

				String pass, pass2;
				do {
					System.out.println("Παρακαλώ εισάγετε Κωδικό Χρήστη");
					pass = in.nextLine();
					System.out.println("Παρακαλώ επιβεβαιώστε τον Κωδικό Χρήστη σας");
					pass2 = in.nextLine();
					if(!pass.equals(pass2)) {
						System.out.println("Οι Κωδικοί σας δεν ταιριάζουν \nΔοκιμάστε Ξανά");
					}
				}while(!pass.equals(pass2));
				
				
				Database.insertIntoUserTable(user_name, pass);
				
				
				System.out.println("Ο Λογαριασμός σας δημιουργήθηκε με επιτυχία");
				System.out.println("Συνδεθείτε για να ανακαλύψεται τις δυνατότητες");

				Database.shutdownConnection();
	}
	
	
		/**Authenticates user's credentials*/
		/*public static String authenticate() {
			Scanner in = new Scanner(System.in);
			
			String name_id = "-5";
			System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας");
			String name=in.nextLine();
			for(int i = 0; i<user_name.size(); i++) {
				if (name.equals(user_name.get(i))){
					name_id = ID.get(i);
				}
			}
			
			String pass_id = "-6";
			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας");
			String pass = in.nextLine();
			for(int i = 0; i<password.size(); i++) {
				if (pass.equals(password.get(i))){
					pass_id = ID.get(i);
				}
			}
				
			if (name_id.equals(pass_id)) {
				System.out.println("Επιτυχία Συνδεσης");
			}else {
				System.out.println("Αποτυχία Συνδεσης\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν\nΔοκιμάστε ξανά");
				authenticate();
			}
			return name_id;
		}*/
		
		public void newLocation(String id) {
			
		}
}
