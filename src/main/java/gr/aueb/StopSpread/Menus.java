package gr.aueb.StopSpread;

/**
 * @author alexd
 *	Printing menus class
 */
public class Menus {
	
	/**
	 * App first menu 
	 */
	public static void firstMenu() {
		System.out.println("Καλώς ήλθατε στο StopSpread!");
		System.out.println("1. Σύνδεση.");
		System.out.println("2. Δημιουργία Νέου Χρήστη.");
	}

	/**
	 * App log in menu
	 * @param id
	 */
	public static void logInMenu(int id) {
		Database.createConnection();
		System.out.println("Καλώς ήλθατε " + Database.findUserName(id) + "!");
		Database.shutdownConnection();
		System.out.println("1. Προσθήκη νέας τοποθεσίας.");
		System.out.println("2. Διαγνώσθηκα Θετικός.");
		
	}

}