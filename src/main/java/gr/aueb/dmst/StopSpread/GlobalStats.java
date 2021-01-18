package gr.aueb.dmst.StopSpread;

/**
 * This class contains and prints general information about Covid-19 according.
 * to World Health Organization.
 */
public class GlobalStats { //beginning of class GlobalStats

	/**
	 * The main method of the class which takes an integer from 1 to 11 and opens
	 * each time the proper web page
	 */
	public void globalStats() { //beginning of method globalStats
		Inputs inp = new Inputs();
		boolean contloop = true;
		Menus menu = new Menus();
		/*
		 * Menu is printed till the user chooses option 11 and prints a message if the.
		 * user puts an invalid option.
		 */
		do {
			System.out.println("Παγκόσμια στατιστικά σύμφωνα "
					+ "με τον Παγκόσμιο Οργανισμό Υγείας.");
			menu.globalStatsMenu();
			int option = inp.rangeInt(1, 11);
			boolean ok = true;
			while (ok) {
				/*
				 * Variable ok checks if choice is 11 and exits. 
				 * the global info in this case
				 */
				switch (option) {
				case 1:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 2:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-how-is-it-transmitted");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 3:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 4:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-risks-and-safety-for-older-people");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 5:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-adolescents-and-youth");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 6:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public/when-and-how-to-use-masks");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 7:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/q-a-children-and-masks-related-to-covid-19");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 8:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19-health-and-safety-in-the-workplace");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 9:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/global-research-on-novel-coronavirus-2019-ncov");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 10:
					Url.openUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/covid-19-vaccines");
					menu.globalStatsMenu();
					option = inp.rangeInt(1, 11);
					break;
				case 11:
					ok = false;
					break;
				}
				contloop = false;
			}
		} while (contloop);

	} //ending of method globalStats

} //ending of class GlobalStats
