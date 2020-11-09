package AirlineDog;

import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		
		
		ReadWrite.load();
		Profile prof = new Profile();

		logInMenu();
		int inp = Inputs.input(1, 2);
		String id = "-1";
		switch (inp) {
		case 1:
			id = prof.authenticate();
			break;

		case 2:
			id =prof.newEntry();
			break;
		}
		System.out.println(id);
		System.out.println(prof.getID());
		
		
		ReadWrite.save();






		

	}

	public static void logInMenu() {
		System.out.println("Καλώς ήλθατε");
		
		System.out.println("1. Σύνδεση");
		System.out.println("2. Δημιουργία Νέου Χρήστη");
	}

}
