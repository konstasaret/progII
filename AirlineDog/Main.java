package AirlineDog;

public class Main {

	public static void main(String[] args) {

		logInMenu();
		int inp = Inputs.input(1, 2);
		Profile prof = new Profile();
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

		/*
		prof.newEntry();
		prof.newEntry();
		
		ReadWrite.write(prof.getID(),"ID.txt");
		ReadWrite.write(prof.getUser_name(),"User.txt");
		ReadWrite.write(prof.getPassword(),"Pass.txt");
		ReadWrite.write(prof.getAddress(),"Address.txt");

		prof.setID(ReadWrite.read("ID.txt"));
		prof.setUser_name(ReadWrite.read("User.txt"));
		prof.setPassword(ReadWrite.read("Pass.txt"));
		prof.setAddress(ReadWrite.read("Address.txt"));
		System.out.println(prof.getID());
		System.out.println(prof.getUser_name());
		System.out.println(prof.getPassword());
		System.out.println(prof.getAddress());*/

	}

	public static void logInMenu() {
		System.out.println("Καλώς ήλθατε");
		
		System.out.println("1. Σύνδεση");
		System.out.println("2. Δημιουργία Νέου Χρήστη");
	}

}
