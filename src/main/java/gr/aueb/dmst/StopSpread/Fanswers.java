package gr.aueb.dmst.StopSpread;

/**
 * This class shows to user the answer he wants to read.
 */
public class Fanswers {

	/**
	 * The main method of the class checks the user's input
	 * and prints the suitable answer.
	 */
	public void freqQuest() {

		Menus menouQ = new Menus();
		Answers ans = new Answers();
		Inputs inp = new Inputs();

		boolean flag = true;

		while (flag) {

			menouQ.menu88();

			int choice = inp.rangeInt(0, 16);

			switch (choice) {
			case 0:
				flag = false;
				break;
			case 1:
				ans.answer1();
				break;
			case 2:
				ans.answer2();
				break;
			case 3:
				ans.answer3();
				break;
			case 4:
				ans.answer4();
				break;
			case 5:
				ans.answer5();
				break;
			case 6:
				ans.answer6();
				break;
			case 7:
				ans.answer7();
				break;
			case 8:
				ans.answer8();
				break;
			case 9:
				ans.answer9();
				break;
			case 10:
				ans.answer10();
				break;
			case 11:
				ans.answer11();
				break;
			case 12:
				ans.answer12();
				break;
			case 13:
				ans.answer13();
				break;
			case 14:
				ans.answer14();
				break;
			case 15:
				ans.answer15();
				break;
			case 16:
				ans.answer16();
				break;
			}// end of switch
		} // end of loop
	} //end of method freqQuest
} //end of Class Fanswers
