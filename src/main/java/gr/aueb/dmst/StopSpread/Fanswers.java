package gr.aueb.dmst.StopSpread;

public class Fanswers {
	public static void fAQ() {

		int choice;
		Menus menouQ = new Menus();
		Answers eisagwgi = new Answers();
		menouQ.menu88();
		System.out.println("Πατήστε 0 αν θέλετε να διαβάσετε γενικές πληροφορίες της έρευνας.");
		System.out.println("Διαφορετικά πατήστε τον αριθμό της ερώτησης που θέλετε από 1 έως και 15.");
		System.out.println("Παρακαλώ εισάγετε την επιλογή σας:");
		choice = Inputs.rangeInt(0, 15);
		boolean flag = true;

		while (flag) {// begging of loop
			switch (choice) {// beggining of switch
			case 0:
				eisagwgi.Eisagwgi();
				break;
			case 1:
				eisagwgi.Answer1();
				break;
			case 2:
				eisagwgi.Answer2();
				break;
			case 3:
				eisagwgi.Answer3();
				break;
			case 4:
				eisagwgi.Answer4();
				break;
			case 5:
				eisagwgi.Answer5();
				break;
			case 6:
				eisagwgi.Answer6();
				break;
			case 7:
				eisagwgi.Answer7();
				break;
			case 8:
				eisagwgi.Answer8();
				break;
			case 9:
				eisagwgi.Answer9();
				break;
			case 10:
				eisagwgi.Answer10();
				break;
			case 11:
				eisagwgi.Answer11();
				break;
			case 12:
				eisagwgi.Answer12();
				break;
			case 13:
				eisagwgi.Answer13();
				break;
			case 14:
				eisagwgi.Answer14();
				break;
			case 15:
				eisagwgi.Answer15();
				break;
			case 16:
				flag = false;
				continue;
			}// ending of switch
				// na ftiajo ti sinexeia stop sinexizo
				// ejereseis
				// -

		} // ending of loop
	}
}
