package AirlineDog;

import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
	
	private static ArrayList<String> ID = new ArrayList<String>();
	private static ArrayList<String> user_name = new ArrayList<String>();
	private static ArrayList<String> password= new ArrayList<String>();
	private static ArrayList<String> address= new ArrayList<String>();

	//default constructor
	public Profile() {
		
	}
	
	//new user constractor
	public Profile(String user_name, String password, String address) {
		Profile.ID.add(String.valueOf(Profile.ID.size()));
		Profile.user_name.add(user_name);
		Profile.password.add(password);
		Profile.address.add(address);
	}


	/**
	 * @return the iD
	 */
	public ArrayList<String> getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(ArrayList<String> iD) {
		ID = iD;
	}


	/**
	 * @return the user_name
	 */
	public ArrayList<String> getUser_name() {
		return user_name;
	}


	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(ArrayList<String> user_name) {
		Profile.user_name = user_name;
	}


	/**
	 * @return the password
	 */
	public ArrayList<String> getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(ArrayList<String> password) {
		Profile.password = password;
	}


	/**
	 * @return the address
	 */
	public ArrayList<String> getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(ArrayList<String> address) {
		Profile.address = address;
	}

	//new user creation
	public String newEntry() {
				Scanner in = new Scanner(System.in);
				
				System.out.println("Παρακαλώ εισάγετε Όνομα Χρήστη");
				String user=in.nextLine();
				boolean duplicate;
				do {
					duplicate = false;
					for(String names : user_name) {
						if(names.contentEquals(user)) {
							System.out.println("Το Όνομα Χρήστη χρησημοποιείται");
							System.out.println("Παρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη");
							user=in.nextLine();
							duplicate = true;
						}
					}
				}while(duplicate == true);

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
				
				System.out.println("Παρακαλώ εισάγετε την Διεύθυνσή σας");
				String address = in.nextLine();
				
				System.out.println("Ο Λογαριασμός σας δημιουργήθηκε με επιτυχία");
				System.out.println("Συνδεθείτε για να ανακαλύψεται τις δυνατότητες");

				new Profile(user, pass, address);

				return String.valueOf(Profile.ID.size());
	}
		//user authentication
		public String authenticate() {
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
		}
		
}
