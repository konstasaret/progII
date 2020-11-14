package AirlineDog;

public class Menu {

	
		
		/*ReadWrite.load();
		
		
		Profile prof = new Profile();
		
		firstMenu();
		int input = Inputs.rangeInt(1, 2);
		String id = "-1";
		switch (input) {
		//Log In
		case 1:
			id = prof.authenticate();
			logInMenu(id);
			int input2 = Inputs.rangeInt(1, 2);
			switch (input2) {
			//location
			case 1:
				prof.newLocation(id);
				break;
			//got the virus
			case 2:
				
				break;
			}
			
			break;
		//Sing Up
		case 2:
			id =prof.newEntry();
			break;
		}
		
		
		ReadWrite.save();*/
	

	private static void firstMenu() {
		System.out.println("Καλώς ήλθατε");
		System.out.println("1. Σύνδεση");
		System.out.println("2. Δημιουργία Νέου Χρήστη");
	}

	private static void logInMenu(String id) {
		Profile prof = new Profile();
		System.out.println("Καλώς ήλθατε "+ prof.getUser_name().get(Integer.parseInt(id)));
		System.out.println("1. Προσθήκη νέας τοποθεσίας");
		System.out.println("2. Κόλλησα Κονδυλώματα!!!!");
		
	}
}
