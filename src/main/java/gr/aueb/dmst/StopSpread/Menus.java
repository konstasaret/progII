package gr.aueb.dmst.StopSpread;

/**
 * Prints menus
 */
public class Menus {
	/**
	 * App's log in menu
	 */
	public void logInMenu() { // beginning of logInMenu
		System.out.println("Καλώς ήλθατε στο StopSpread!");
		System.out.println("1. Σύνδεση.");
		System.out.println("2. Δημιουργία Νέου Χρήστη.");
	} // ending of logInMenu

	/**
	 * App's functions menu
	 */
	public void firstMenu() { // beginning of firstMenu
		System.out.println("Καλώς ήλθατε!");
		System.out.println("1. Προσθήκη νέας τοποθεσίας.");
		System.out.println("2. Διαγνώσθηκα Θετικός.");
		System.out.println("3. Δες τις τοποθεσίες σου");
		System.out.println("4. Δες στατιστικά για την Ελλάδα");
		System.out.println("5. Δες στατιστικά για όλο τον Κόσμο");
		System.out.println("6. Δες περιστατικά του ιού");
		System.out.println("7. Συχνές Ερωτήσεις σχετικά με τον CONVID-19");
		System.out.println("8. Διέγραψε μια τοποθεσία σου");
		System.out.println("9. Αξιολογηση της εφαρμογής");
		System.out.println("10. Διαγραφή Χρήστη και δεδομένων");
		System.out.println("11. Αποσύνδεση");
	} // end of firstMenu

	/**
	 * Prints the first menu of class with Greek statistics.
	 */
	public void greekStatsMenu() { // beginning of GreekStatsMenu
		System.out.println("1. Ημερήσια επισκόπηση.");
		System.out.println("2. Στατιστικά στοιχεία ανά γεωγραφικό διαμέρισμα.");
		System.out.println("3. Κρούσματα ανά ημέρα από την αρχή της πανδημίας.");
		System.out.println("4. Έξοδος.");
		System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
	} // end of GreekStatsMenu

	/**
	 * Prints the second menu which contains information about each geo area.
	 */
	public void greekStatsMenu2() { // beginning of GreekStatsMenu
		System.out.println("1.Γεωγραφικό Διαμέρισμα Αττική");
		System.out.println("2.Γεωγραφικό Διαμέρισμα Ήπειρος");
		System.out.println("3.Γεωγραφικό Διαμέρισμα Θεσσαλία");
		System.out.println("4.Γεωγραφικό Διαμέρισμα Θράκη");
		System.out.println("5.Γεωγραφικό Διαμέρισμα Κρήτη");
		System.out.println("6.Γεωγραφικό Διαμέρισμα Μακεδονία ");
		System.out.println("7.Γεωγραφικό Διαμέρισμα Νησιά Αιγαίου Πελάγους");
		System.out.println("8.Γεωγραφικό Διαμέρισμα Νησιά Ιονίου Πελάγους");
		System.out.println("9.Γεωγραφικό Διαμέρισμα Πελοπόννησος");
		System.out.println("10.Γεωγραφικό Διαμέρισμα Στερεά Ελλάδα");
		System.out.println("11. Έξοδος");
	} // end of GreekStatsMenu

	/**
	 * Prints the user's option about global statistics.
	 */
	public void globalStatsMenu() { // beginning of GlobalStatsMenu
		System.out.println("1. Γενικά για τον Covid-19.");
		System.out.println("2. Μετάδοση.");
		System.out.println("3. Συμβουλές για το κοινό.");
		System.out.println("4. Κίνδυνοι και ασφάλεια των ηλικιωμένων.");
		System.out.println("5. Νέοι και έφηβοι.");
		System.out.println("Χρήση μάσκας:");
		System.out.println("6. Γενικά.");
		System.out.println("7. Χρήση μάσκας και παιδιά.");
		System.out.println("8. Υγεία και ασφάλεια στον εργασιακό χώρο.");
		System.out.println("9. Έρευνα και ανάπτυξη.");
		System.out.println("10. Σχετικά με το εμβόλιο.");
		System.out.println("11. Έξοδος.");
		System.out.println("Παρακαλώ εισάγετε τον αριθμό που αντιστοιχεί στην" + " επιθυμητή επιλογή!");
	} // end of GlobalStatsMenu

	/**
	 * This method will be used for evaluating of our app. It prints the choices of
	 * Evaluation menu
	 */
	public void printMenu() { // beginning of printMenu
		System.out.println("***********Μενού Αξιολόγησης***********");
		System.out.println("1.Ήδη Υπάρχουσα Αξιολόγηση - Γραφική Αναπαράσταση των Δεδομένων");
		System.out.println("2.Εισαγωγή Αξιολόγησης");
		System.out.println("3.Εισαγωγή σχολίου σχετικά με την εφαρμογή");
		System.out.println("4.Σχόλια άλλων χρηστών");
		System.out.println("5.Έξοδος από το Μενού Αξιολόγησης");
	} // end of printMenu

	/**
	 * This method prints the user's options about what class Stories can implement.
	 */
	public void storiesMenu() { // beginning of storiesMenu
		System.out.println("Μενού επιλογών:");
		System.out.println("1. Ανάγνωση ιστορίας.");
		System.out.println("2. Αποστολή της δικής μου ιστορίας!");
		System.out.println("3. Έξοδος");
	} // end of storiesMenu

	/**
	 * This method prints the user's options about the evaluation of our app.
	 */
	public void insertMenu() { // beginning of insertMenu
		System.out.println("Παρακαλώ εισάγετε τη βαθμολογία σας:");
		System.out.println("Κλίμακα βαθμολογίας: ");
		System.out.println("1 = Πολύ Κακή Εφαρμογή");
		System.out.println("2 = Κακή Εφαρμογή");
		System.out.println("3 = Μέτρια εφαρμογή");
		System.out.println("4 = Καλή εφαρμογή");
		System.out.println("5 = Πολύ Καλή εφαρμογή");
		System.out.println("Η βαθμολογία μου είναι:");
	} // end of insertMenu

	/** This menu prints user's options about frequent Covid - questions. */
	public void menu88() { // beginning of menu88
		System.out.println("********* ΣΥΧΝΕΣ ΕΡΩΤΗΣΕΙΣ ΣΧΕΤΙΚΑ ΜΕ ΤΟΝ COVID-19 *********");
		System.out.println("Ερώτηση 1 : Μεταδίδεται ο Covid-19 από άνθρωπο σε άνθρωπο;");
		System.out.println("Ερώτηση 2 : Ποια είναι η περίοδος επώασης;");
		System.out.println("Ερώτηση 3 : Ποια είναι τα συμπτώματα, τα εργαστηριακά ευρήματα"
				+ " και η πρόγνωση της λοίμωξης από τον ιό;");
		System.out.println("Ερώτηση 4 : Μπορούν οι ασυμπτωματικοί φορείς να μεταδίδουν τον ιό;");
		System.out.println("Ερώτηση 5 : Επιβιώνει ο ιός σε επιφάνειες;");
		System.out.println("Ερώτηση 6 : Υπάρχει περίπτωση να κολλήσω από το κατοικίδιό μου;");
		System.out.println("Ερώτηση 7 : Πρέπει να φοράω μάσκα; Πρέπει να φοράνε μάσκα τα παιδιά μου;");
		System.out.println("Ερώτηση 8 : Μπορώ να αποδέχομαι με ασφάλεια πακέτα από άλλα κράτη που ενδημεί ο ιός;");
		System.out.println("Ερώτηση 9 : Μπορεί να κολλήσω τον ιό με τη βρώση τροφής;");
		System.out.println("Ερώτηση 10 : Μπορώ να ταξιδέψω στο αεροπλάνο;");
		System.out.println("Ερώτηση 11 : Ποια μέτρα πρόληψης μπορώ να λάβω στην καθημερινότητά μου;");
		System.out.println("Ερώτηση 12 : Πώς γίνεται η διάγνωση;");
		System.out.println("Ερώτηση 13 : Πόσο θανατηφόρος είναι ο ιός;");
		System.out.println("Ερώτηση 14 : Τι πρέπει να κάνω εάν νομίζω ότι έχω λοίμωξη από τον νέο κορωνοϊό;");
		System.out.println("Ερώτηση 15 : Μπορεί κάποιος που έχει αναρρώσει να συνεχίσει "
				+ "να είναι φορέας και να μεταδίδει τον ιό;;");
		System.out.println(
				"Ερώτηση 16 : Η έλευση της άνοιξης και του καλοκαιριού θα βοηθήσουν στην εξάλειψη του ιού;;");
		System.out.println("Εισάγετε τον αριθμό της ερώτησης που επιθυμείτε να διαβάσετε (από 0 έως και 16).");
		System.out.println("Για έξοδο πληκτρολογείστε 0");
		System.out.println("Παρακαλώ εισάγετε την επιλογή σας :");
	} // end of menu88

}
