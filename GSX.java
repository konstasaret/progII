import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class GSX {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Scanner scan = new Scanner(System.in);
			boolean contloop = true;
			boolean contloopin = true;
			do {
				try {
					System.out.println("Διαθέσιμες επιλογές:");
					printMenu();
					int choice = sc.nextInt();
					boolean flag2;
					int option;
					while(choice != 4) {
						if (choice == 1) {
							showSite("https://covid19.gov.gr/covid19-live-analytics/");
						} else if (choice == 2) {
							do {
								try {
								menu2();
								option = scan.nextInt();
								flag2 = true;
									while(flag2 == true) {
										switch(option){ //beginning of switch
										case 1:
											showSite("https://covid19greece.com/geografiko-diamerisma/attiki");
											break;
										case 2:
											showSite("https://covid19greece.com/geografiko-diamerisma/ipeiros");
											break;
										case 3:
											showSite("https://covid19greece.com/geografiko-diamerisma/thessalia");
											break;
										case 4:
											showSite("https://covid19greece.com/geografiko-diamerisma/thraki");
											break;
										case 5:
											showSite("https://covid19greece.com/geografiko-diamerisma/kriti");
											break;
										case 6:
											showSite("https://covid19greece.com/geografiko-diamerisma/makedonia");
											break;
										case 7:
											showSite("https://covid19greece.com/geografiko-diamerisma/nisia-aigaioy-pelagoys");
											break;
										case 8:
											showSite("https://covid19greece.com/geografiko-diamerisma/nisia-ionioy-pelagoys");
											break;
										case 9:
											showSite("https://covid19greece.com/geografiko-diamerisma/peloponnisos");
											break;
										case 10:
											showSite("https://covid19greece.com/geografiko-diamerisma/sterea-ellada");
											break;
										case 11:
											flag2 = false;
											continue;
										default: 
											System.out.println(" Μη έγκυρη επιλογή (οι επιλογές είναι 1,2,3,4,5,6,7,8,9,10");
											break;
										}//end of switch
									menu2();
									option = scan.nextInt();
									contloopin = false;
								}//end of loop
								} catch (ArithmeticException e) {
									System.err.println("ArithmeticException. Δοκιμάστε ξανά: ");
								} catch (InputMismatchException e) {
									System.err.println("InputMismatchException. Δοκιμάστε ξανά: ");
									scan.nextLine();
								} 
								} while (contloopin);
						} else if (choice == 3) {
							showSite("https://betmasters.gr/koronoios/50170-statistika-stin-ellada-prognostika/");
						} else if (choice == 4) {
							break;
						} else {
							System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά");
						}
						printMenu();
						choice = sc.nextInt();
					}	
			contloop = false;
			} catch (ArithmeticException e) {
				System.err.println("ArithmeticException. Δοκιμάστε ξανά: ");
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Παρακλώ εισάγεται αριθμό!\\n Δοκιμάστε ξανά: ");
			} 
		} while (contloop);
	}
		public static void printMenu() {
			System.out.println("1. Ημερήσια επισκόπηση.");
			System.out.println("2. Στατιστικά στοιχεία ανά γεωγραφικό διαμέρισμα.");
			System.out.println("3. Κρούσματα ανά ημέρα από την αρχή της"
				+ " πανδημίας.");
			System.out.println("4. Έξοδος.");
			System.out.println("Εισάγετε τον αριθμό που αντιστοιχεί στην επιθυμητή επιλογή.");
		}
		
		public static void menu2() {
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
		public static void showSite(String url) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (IOException ex) {
				Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
}