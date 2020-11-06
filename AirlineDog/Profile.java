package AirlineDog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Profile {
	private int ID;
	private static int number_of_users;
	private String user_name;
	private String password;
	private String address;
	protected static ArrayList<Profile> profs = new ArrayList<Profile>();

	
	public Profile(String user_name, String password, String address) {
		this.number_of_users++;
		this.ID = number_of_users;
		this.user_name = user_name;
		this.password = password;
		this.address = address;
	}
	
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	public static void newEntry() {
				Scanner in = new Scanner(System.in);
				
				System.out.println("Give User name");
				String user=in.nextLine();
				System.out.println(user);
				
				System.out.println("Give pass");
				String pass = in.nextLine();
				System.out.println(pass);
				
				System.out.println("Give Address");
				String address = in.nextLine();
				System.out.println(address);
				
				Profile prof = new Profile(user, pass, address);
				profs.add(prof);
	}

		public void authenticate(String username, String pass) {
			
		}
}
