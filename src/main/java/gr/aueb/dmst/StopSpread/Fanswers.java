package gr.aueb.dmst.StopSpread;

public class Fanswers {
	public void freqQuest() {

		// int choice = 100;
		// Scanner sc = new Scanner(System.in);
		Menus menouQ = new Menus();
		Answers eisagwgi = new Answers();
		menouQ.menu88();
		Inputs inp = new Inputs();

		System.out.println("Πατήστε 0 αν θέλετε να διαβάσετε γενικές πληροφορίες της έρευνας");
		System.out.println("Διαφορετικά πατήστε τον αριθμό της ερώτησης που θέλετε από 1 έως και 15");
		System.out.println("Παρακαλώ εισάγετε την επιλογή σας:");
		int choice = inp.rangeInt(0, 16);
		boolean flag = true;

		while (flag) { // beginning of loop
			switch (choice) {// beginning of switch
			case 0:
				eisagwgi.eisagwgi();
				break;
			case 1:
				eisagwgi.answer1();
				break;
			case 2:
				eisagwgi.answer2();
				break;
			case 3:
				eisagwgi.answer3();
				break;
			case 4:
				eisagwgi.answer4();
				break;
			case 5:
				eisagwgi.answer5();
				break;
			case 6:
				eisagwgi.answer6();
				break;
			case 7:
				eisagwgi.answer7();
				break;
			case 8:
				eisagwgi.answer8();
				break;
			case 9:
				eisagwgi.answer9();
				break;
			case 10:
				eisagwgi.answer10();
				break;
			case 11:
				eisagwgi.answer11();
				break;
			case 12:
				eisagwgi.answer12();
				break;
			case 13:
				eisagwgi.answer13();
				break;
			case 14:
				eisagwgi.answer14();
				break;
			case 15:
				eisagwgi.answer15();
				break;
			case 16:
				flag = false;
				continue;
			}// end of switch
		} // end of loop
	}
}
