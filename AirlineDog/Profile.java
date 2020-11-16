package AirlineDog;

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
		public static void authenticate() {
			Database.createConnection();		

			Scanner in = new Scanner(System.in);
			
			System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας");
			String name = in.nextLine();
			
			String userPass = Database.findUserName(name);
			while (userPass.equals("-1")) {
				System.out.println("Αποτυχία Συνδεσης\nΤο Όνομα Χρήστη δεν υπάρχει\nΠαρακαλώ προσπαθήστε ξανά :");
				name = in.nextLine();
				userPass = Database.findUserName(name);
			}
			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας");
			String pass = in.nextLine();
			
				
			if (userPass.equals(pass)) {
				System.out.println("Επιτυχία Συνδεσης");
			}else {
				while(!userPass.equals(pass)) {
				System.out.println("Αποτυχία Συνδεσης\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν\nΔοκιμάστε ξανά");
				System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας");
				pass = in.nextLine();
				}
			}
			Database.shutdownConnection();

		}
		
		public void newLocation(String id) {
			
		}
}
