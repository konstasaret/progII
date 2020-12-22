package gr.aueb.dmst.StopSpread;

public class Fanswers {
	// public static void fAQ() {
	public static void main(String[] args) {
		Menus menouQ = new Menus();
		Answers eisagwgi = new Answers();

		boolean loop = true;

		do {
			menouQ.menu88();
			menouQ.fAQMenu1();
			int choice = Inputs.rangeInt(0, 17);
			boolean flag = true;
			while (flag) {// begging of loop
				switch (choice) {// beggining of switch
				case 1:
					eisagwgi.Eisagwgi();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 2:
					eisagwgi.Answer1();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 3:
					eisagwgi.Answer2();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 4:
					eisagwgi.Answer3();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 5:
					eisagwgi.Answer4();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 6:
					eisagwgi.Answer5();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 7:
					eisagwgi.Answer6();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 8:
					eisagwgi.Answer7();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 9:
					eisagwgi.Answer8();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 10:
					eisagwgi.Answer9();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 11:
					eisagwgi.Answer10();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 12:
					eisagwgi.Answer11();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 13:
					eisagwgi.Answer12();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 14:
					eisagwgi.Answer13();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 15:
					eisagwgi.Answer14();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 16:
					eisagwgi.Answer15();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 17:
					eisagwgi.Answer16();
					menouQ.menu88();
					choice = Inputs.rangeInt(0, 17);
					break;
				case 0:
					flag = false;
					break;
				}
				loop = false;
			} // ending of loop
		} while (loop);
	}
}
