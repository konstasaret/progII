package AirlineDog;

public class Main {

	public static void main(String[] args) {
		Profile prof = new Profile();
		ReadWrite.load();
		prof.newEntry();
		System.out.println(prof.getUser_name());
		ReadWrite.save();






		/*logInMenu();
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
		System.out.println(prof.getID());*/

	}

	public static void logInMenu() {
		System.out.println("Καλώς ήλθατε");
		
		System.out.println("1. Σύνδεση");
		System.out.println("2. Δημιουργία Νέου Χρήστη");
	}

}
