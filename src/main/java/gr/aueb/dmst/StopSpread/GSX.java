package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**This class is relates to the statistics of covid per Area 
 * Specifically class GSX shows both statistics and graphs
 * of Attiki,Ipeiros,Thessalloniki,Thraki,
 * Kriti,MakedoniamNisia Aigeou,Nisia Ioniou,
 * Peloponissos,Sterea Ellada  */

public class GSX {
		public static void main(String[] args) {
			boolean contloop = true;
			boolean contloopin = true;
			do {
					System.out.println("Διαθέσιμες επιλογές:");
					/**In this point I call the static method GreekStatsMenu()
					 *which shows the alternatives about what Area 
					 *you want to see both the Statistics and graphs    */
					
					Menus.GreekStatsMenu();
					int choice = Inputs.rangeInt(1, 4);
					boolean flag2;
					int option;
					while(choice != 4) { //beggining of loop
						if (choice == 1) {
							showSite("https://covid19.gov.gr/covid19-live-analytics/");
						} else if (choice == 2) {
							do {
								Menus.GreekStatsMenu2();
								option = Inputs.rangeInt(1, 11);
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
										}//end of switch
									Menus.GreekStatsMenu2();
									option = Inputs.rangeInt(1, 11);
									contloopin = false;
								}//end of loop
								
								} while (contloopin);
						} else if (choice == 3) {
							showSite("https://betmasters.gr/koronoios/50170-statistika-stin-ellada-prognostika/");
						} else if (choice == 4) {
							break;
						} else {
							System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά");
						}
						/**The static method GreekStatsMenu() shows again the Menu 
						 * with the alternatives the user can call */
						
						Menus.GreekStatsMenu();  
						choice = Inputs.rangeInt(1, 4);
					}	
			contloop = false;
			
		} while (contloop);
	}
		
		public static void showSite(String url) {
			try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (IOException ex) {
				Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
}