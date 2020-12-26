package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**This class shows the statistics and graphs per area.
 * (Attiki,Ipiros,Thesalsaloniki,
 * Thraki,Kriti,Makedonia,Nisia Ioniou,
 * Nisia Aigeou,Sterea Ellada,Peloponnisos)*/

/**the static method GreekStatusMenu appears the choices
menu.GreekStatsMenu(); * that user can choose per area*/

/**{@authors
 * Vicky
 * Chrysoyla
 * Giannis
 * Evaggelia}*/

public class GSX {
  public static void gsxToTCP() {
    boolean contloop = true;
    boolean contloopin = true;
    Menus menu = new Menus();
    do {
      System.out.println("Διαθέσιμες επιλογές:");
      int choice = Inputs.rangeInt(1, 4);
      boolean flag2;
      int option;
      while (choice != 4) { //beginning of loop
        if (choice == 1) {
          showSite("https://covid19.gov.gr/covid19-live-analytics/");
        } else if (choice == 2) {
          do {
            menu.greekStatsMenu2();
            option = Inputs.rangeInt(1, 11);
            flag2 = true;
            while (flag2 == true) {
              switch (option) { //beginning of switch
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
              } //end of switch
              menu.greekStatsMenu2();
              option = Inputs.rangeInt(1, 11);
              contloopin = false;
            } //end of loop

          } while (contloopin);
        } else if (choice == 3) {
          showSite("https://betmasters.gr/koronoios/50170-statistika-stin-ellada-prognostika/");
        } else if (choice == 4) {
          break;
        } else {
          System.out.println("Λάθος εισαγωγή. Παρακαλώ προσπαθήστε ξανά");
        }
        menu.greekStatsMenu();
        choice = Inputs.rangeInt(1, 4);
      }
      contloop = false;
    } while (contloop);
  }
  //small change to see if it's working
  /**method that opens the websites.
   */
  public static void showSite(String url) {
    try {
      java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    } catch (IOException ex) {
      Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}