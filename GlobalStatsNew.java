import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.InputMismatchException;

public class GlobalStatsNew {
	public static void main(String [] args ) {
		boolean contloop = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Παγκόσμια στατιστικά σύμφωνα με τον Παγκόσμιο Οργανισμό Υγείας.");
				printMenu();
				int option = sc.nextInt();
				boolean ok = true;
				while (ok == true) {
					switch (option) {
					case 1:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19");
						printMenu();
						option = sc.nextInt();
						break;
					case 2:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-how-is-it-transmitted");
						printMenu();
						option = sc.nextInt();
						break;
					case 3:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public");
						printMenu();
						option = sc.nextInt();
						break;
					case 4:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-risks-and-safety-for-older-people");
						printMenu();
						option = sc.nextInt();
						break;
					case 5:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-adolescents-and-youth");
						printMenu();
						option = sc.nextInt();
						break;
					case 6:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/when-and-how-to-use-masks");
						printMenu();
						option = sc.nextInt();
						break;
					case 7:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/q-a-children-and-masks-related-to-covid-19");
						printMenu();
						option = sc.nextInt();
						break;
					case 8:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-health-and-safety-in-the-workplace");
						printMenu();
						option = sc.nextInt();
						break;
					case 9:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/global-research-on-novel-coronavirus-2019-ncov");
						printMenu();
						option = sc.nextInt();
						break;
					case 10:
						opt("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/covid-19-vaccines");
						printMenu();
						option = sc.nextInt();
						break;
					case 11:
						ok = false;
						break;
					default: 
						System.out.println("Μη έγκυρη επιλογή.Παρακαλώ προσπαθήστε ξανά!");
						printMenu();
						option = sc.nextInt();				
					}
				contloop = false;
				}
			} catch (ArithmeticException e) {
				System.err.println("ArithmeticException. Δοκιμάστε ξανά: ");
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Παρακλώ εισάγεται αριθμό!\nΔοκιμάστε ξανά: ");
			} 
		} while (contloop);
	}
	public static void printMenu() {
		System.out.println("1. Γενικά για τον Covid-19.");
		System.out.println("2. Μετάδοση.");	
		System.out.println("3. Συμβουλές για το κοινό.");
		System.out.println("4. Κίνδυνοι και ασφάλεια των ηλικιωμένων.");		
		System.out.println("5. Νέοι και έφηβοι.");
		System.out.println("Χρήση μάσκας:");
		System.out.println("     6. Γενικά.");		
		System.out.println("     7. Χρήση μάσκας και παιδιά.");	
		System.out.println("8. Υγεία και ασφάλεια στον εργασιακό χώρο.");		
		System.out.println("9. Έρευνα και ανάπτυξη.");		
		System.out.println("10. Σχετικά με το εμβόλιο.");
		System.out.println("11. Έξοδος.");
		System.out.println("Παρακαλώ εισάγετε τον αριθμό που αντιστοιχεί στην"
				+ " επιθυμητή επιλογή!");
		}
	public static void opt(String url) {
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException ex) {
			Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
