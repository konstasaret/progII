package gr.aueb.dmst.StopSpread;

/**
 * @author alexd
 *	Printing menus class
 */
public class Menus {
	
	/**
	 * App's first menu 
	 */
	public static void firstMenu() {
		System.out.println("Καλώς ήλθατε στο StopSpread!");
		System.out.println("1. Σύνδεση.");
		System.out.println("2. Δημιουργία Νέου Χρήστη.");
	}

	/**
	 * App's log in menu
	 * @param id
	 */
	public static void logInMenu(int id) {
		Database.createConnection();
		System.out.println("Καλώς ήλθατε " + Database.findUserName(id) + "!");
		Database.shutdownConnection();
		System.out.println("1. Προσθήκη νέας τοποθεσίας.");
		System.out.println("2. Διαγνώσθηκα Θετικός.");
		
	}
	
	/** Prints the first menu 
	 * of class with greek statistics
	 */
	public static void GreekStatsMenu() {
		System.out.println("1. Ημερήσια επισκόπηση.");
		System.out.println("2. Στατιστικά στοιχεία ανά γεωγραφικό διαμέρισμα.");
		System.out.println("3. Κρούσματα ανά ημέρα από την αρχή της πανδημίας.");
		System.out.println("4. Έξοδος.");
		System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
	}
	
	/** Prints the second menu which 
	 * contains information about 
	 * each geo area
	 */
	public static void GreekStatsMenu2() {
		System.out.println("1.Γεωγραφικό Διαμέρισμα Αττική ");
		System.out.println("2.Γεωγραφικό Διαμέρισμα Ήπειρος ");
		System.out.println("3.Γεωγραφικό Διαμέρισμα Θεσσαλία ");
		System.out.println("4.Γεωγραφικό Διαμέρισμα Θράκη ");
		System.out.println("5.Γεωγραφικό Διαμέρισμα Κρήτη ");
		System.out.println("6.Γεωγραφικό Διαμέρισμα Μακεδονία ");
		System.out.println("7.Γεωγραφικό Διαμέρισμα Νησιά Αιγαίου Πελάγους");
		System.out.println("8.Γεωγραφικό Διαμέρισμα Νησιά Ιονίου Πελάγους");
		System.out.println("9.Γεωγραφικό Διαμέρισμα Πελοπόννησος ");
		System.out.println("10.Γεωγραφικό Διαμέρισμα Στερεά Ελλάδα");
		System.out.println("11. Έξοδος");
	    System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
	}

}