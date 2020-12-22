package gr.aueb.dmst.StopSpread;

/**
 * printing menu class
 *
 */
public class Menus {

	/**
	 * App's log in menu
	 */
	public void logInMenu() { // beggining of logInMenu
		System.out.println("Καλώς ήλθατε στο StopSpread!");
		System.out.println("1. Σύνδεση.");
		System.out.println("2. Δημιουργία Νέου Χρήστη.");
	} // ending of logInMenu

	/**
	 * App's functions menu
	 *
	 * @param id
	 */
	public void firstMenu(int id) { // begginig of firstMenu
		System.out.println("Καλώς ήλθατε!");
		System.out.println("1. Προσθήκη νέας τοποθεσίας.");
		System.out.println("2. Διαγνώσθηκα Θετικός.");
		System.out.println("3. Διαγραφή Χρήστη και δεδομένων");
		System.out.println("4. Δες τις τοποθεσίες σου");
		System.out.println("5. Δες στατιστικά για όλες τις περιοχές");
		System.out.println("6. Δες περιστατικά του ιού");
		System.out.println("7. Αποσύνδεση");
	} // ending of firstMenu

	/**
	 * Prints the first menu of class with greek statistics
	 */
	public void GreekStatsMenu() { // begginig of GreekStatsMenu
		System.out.println("1. Ημερήσια επισκόπηση.");
		System.out.println("2. Στατιστικά στοιχεία ανά γεωγραφικό διαμέρισμα.");
		System.out.println("3. Κρούσματα ανά ημέρα από την αρχή της πανδημίας.");
		System.out.println("4. Έξοδος.");
		System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
	} // ending of GreekStatsMenu

	/**
	 * Prints the second menu which contains information about each geo area
	 */
	public void GreekStatsMenu2() { // Begging of GreekStatsMenu
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
		System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
	} // ending of GreekStatsMenu

	/**
	 * Prints the user's option about global statistics
	 */
	public void GlobalStatsMenu() { // Begging of GlobalStatsMenu
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
	} // ending of GlobalStatsMenu

	/**
	 * this method will be used as menu for the evaluation of our app it prints the
	 * choices of Evaluation menu
	 */
	public void printMenu() { // beggining of printMenu
		System.out.println("***********Μενού Αξιολόγησης***********");
		System.out.println("1.Ήδη Υπάρχουσα Αξιολόγηση-Γραφική Αναπαράσταση των Δεδομένων");
		System.out.println("2.Εισαγωγή Αξιολόγησης");
		System.out.println("3.Εισαγωγή σχολίου σχετικά με την εφαρμογή");
		System.out.println("4.Έξοδος από το Μενού Αξιολόγησης");
	} // ending of printMenu

	/**
	 * This method prints the user's options about what Stories class can implements
	 */
	public void storiesMenu() { // beggining of storiesMenu
		System.out.println("Μενού επιλογών:");
		System.out.println("1. Ανάγνωση ιστορίας.");
		System.out.println("2. Αποστολή της δικής μου ιστορίας!");
		System.out.println("3. Έξοδος");
	} // ending of storiesMenu

	/**
	 * This method prints the stories that are available to user if he selects to
	 * read a story
	 */
	public void readStories() { // beggining of readStories
		System.out.println("Πραγματικές ιστορίες ανθρώπων που νόσησαν με" + " Κορονοϊό.");
		System.out.println("1. 6+1 μαρτυρίες για την καθημερινότητα του ιού "
				+ "από διάφορες γωνιές του πλανήτη, με ελληνική \"ματιά\" ");
		System.out.println("2. Μαρτυρίες πρώην ασθενών: Η ζωή μετά τον" + " κορονοϊό");
		System.out.println("3. Νιώθω σαν να έχω άνοια»: Ιστορίες ασθενών που"
				+ " ανάρρωσαν από κορονοϊό αλλά άρχισαν να ξεχνούν.");
		System.out.println("4. Έξοδος.");
		System.out.println("Ποια ιστορία επιθυμείτε να διαβάσετε;");
	} // ending of readStories

	/**
	 * This method prints the user's options about evaluate our app
	 */
	public void insertMenu() { // beggining of insertMenu
		System.out.println("Παρακαλώ εισάγετε τη βαθμολογία σας:");
		System.out.println("Κλίμακα βαθμολογίας: ");
		System.out.println("1 = Πολύ Κακή Εφαρμογή");
		System.out.println("2 = Κακή Εφαρμογή");
		System.out.println("3 = Μέτρια εφαρμογή");
		System.out.println("4 = Καλή εφαρμογή");
		System.out.println("5 = Πολύ Καλή εφαρμογή");
		System.out.println("Η βαθμολογία μου είναι:");
	} // ending of insertMenu

	/** This menu prints user's options about frequent Covid - questions */
	public void menu88() { // begginig of menu88
		System.out.println("******* ΣΥΧΝΕΣ ΕΡΩΤΗΣΕΙΣ ΣΧΕΤΙΚΑ ΜΕ ΤΟ ΝΕΟ ΚΟΡΩΝΟΪΟ COVID-19*******");
		System.out.println("1. Εισαγωγή");
		System.out.println("Ερώτηση 2 : Μεταδίδεται ο νέος κορωνοϊός Covid-19 από άνθρωπο σε άνθρωπο?");
		System.out.println("Ερώτηση 3 : Ποια είναι η περίοδος επώασης?");
		System.out.println(
				"Ερώτηση 4 : Ποια είναι τα συμπτώματα, τα εργαστηριακά ευρήματα και η πρόγνωση της λοίμωξης από τον ιό?");
		System.out.println("Ερώτηση 5 : Μπορούν οι ασυμπτωματικοί φορείς να μεταδίδουν τον ιό?");
		System.out.println("Ερώτηση 6 : Επιβιώνει ο ιός σε επιφάνειες??");
		System.out.println("Ερώτηση 7 : Υπάρχει περίπτωση να κολλήσω από το κατοικίδιό μου?");
		System.out.println("Ερώτηση 8 : Πρέπει να φοράω μάσκα? Πρέπει να φοράνε μάσκα τα παιδιά μου?");
		System.out.println(
				"Ερώτηση 9 : Μπορώ να αποδέχομαι με ασφάλεια πακέτα από Κίνα ή από άλλα κράτη που ενδημεί ο ιός?");
		System.out.println("Ερώτηση 10 : Μπορεί να κολλήσω τον ιό με τη βρώση τροφής?");
		System.out.println("Ερώτηση 11 : Μπορώ να ταξιδέψω στο αεροπλάνο??");
		System.out.println("Ερώτηση 12 : Ποια μέτρα πρόληψης μπορώ να λάβω στην καθημερινότητά μου?");
		System.out.println("Ερώτηση 13 : Πώς γίνεται η διάγνωση?");
		System.out.println("Ερώτηση 14 : Πόσο θανατηφόρος είναι ο ιός?");
		System.out.println("Ερώτηση 15 : Τι πρέπει να κάνω εάν νομίζω ότι έχω λοίμωξη από τον νέο κορωνοϊό??");
		System.out.println(
				"Ερώτηση 16 : Μπορεί κάποιος που έχει αναρρώσει να συνεχίσει να είναι φορέας και να μεταδίδει τον ιό??");
		System.out
				.println("Ερώτηση 17 : Η έλευση της άνοιξης και του καλοκαιριού θα βοηθήσουν στην εξάλειψη του ιού??");
		System.out.println("Για έξοδο πληκτρολογείστε 0.");

	} // ending of menu88

	/** This method asks user about the answer that he/she wants to read */
	public void fAQMenu1() {
		System.out.println("Εισάγετε τον αριθμό της ερώτησης που επιθυμείτε να διαβάσετε (από 1 έως και 17.");
		System.out.println("Για έξοδο πληκτρολογείστε 0.");
		System.out.println("Παρακαλώ εισάγετε την επιλογή σας:");
	}
}
