package AirlineDog;

import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
	
	private static int number_of_users=0;
	private static ArrayList<String> ID = new ArrayList<String>();
	private static ArrayList<String> user_name = new ArrayList<String>();
	private static ArrayList<String> password= new ArrayList<String>();
	private static ArrayList<String> address= new ArrayList<String>();

	//default constructor
	public Profile() {
		
	}
	//new user constractor
	public Profile(String user_name, String password, String address) {
		this.ID.add(String.valueOf(number_of_users++));
		this.user_name.add(user_name);
		this.password.add(password);
		this.address.add(address);
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
		this.user_name = user_name;
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
		this.password = password;
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
		this.address = address;
	}

	//new user's credentials
	public void newEntry() {
				Scanner in = new Scanner(System.in);
				
				System.out.println("Give User name");
				String user=in.nextLine();
				
				System.out.println("Give pass");
				String pass = in.nextLine();
				
				System.out.println("Give Address");
				String address = in.nextLine();
				
				Profile prof = new Profile(user, pass, address);
	}

		public void authenticate(String username, String pass) {
			
		}
}
