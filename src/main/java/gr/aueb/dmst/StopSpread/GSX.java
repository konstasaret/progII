package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class shows the statistics and graphs per area.
 * (Attiki,Ipiros,Thesalsaloniki, Thraki,Kriti,Makedonia,Nisia Ioniou, Nisia
 * Aigeou,Sterea Ellada,Peloponnisos)
 */
public class GSX {

    /**
     * This method prints the appropriate menu, reads an integer from user which is
     * his/her choice and opens the suitable web site each time.
     */
    public void gsxToTCP() {
        Inputs inp = new Inputs();
        boolean contloop = true;
        Menus menu = new Menus();
        do {
            System.out.println("Διαθέσιμες επιλογές:");
            menu.greekStatsMenu();
            int choice = inp.rangeInt(1, 4);
            int option;
            while (choice != 4) { // beginning of loop
                if (choice == 1) {
                    String url = decideURL(choice, 0);
                    showSite(url);
                } else if (choice == 2) {
                    while (true) {
                        menu.greekStatsMenu2();
                        option = inp.rangeInt(1, 11);

                        String url = decideURL(choice, option);
                        if (!url.equals("exit"))
                            showSite(url);
                        else
                            break;
                    } // end of loop
                } else if (choice == 3) {
                    String url = decideURL(choice, 0);
                    showSite(url);
                }

                menu.greekStatsMenu();
                choice = inp.rangeInt(1, 4);
            }
            contloop = false;
        } while (contloop);
    }

    public String decideURL(int choice, int NomosOption) {
        String url = "";

        if (choice == 1)
            url = "https://covid19.gov.gr/covid19-live-analytics/";
        else if (choice == 3)
            // TODO den einai kai poly episimo ayto to site
            url = "https://betmasters.gr/koronoios/50170-statistika-stin-ellada-prognostika/";
        else if (choice == 2) {
            switch (NomosOption) { // beginning of switch
            case 1:
                url = "https://covid19greece.com/geografiko-diamerisma/attiki";
                break;
            case 2:
                url = "https://covid19greece.com/geografiko-diamerisma/ipeiros";
                break;
            case 3:
                url = "https://covid19greece.com/geografiko-diamerisma/thessalia";
                break;
            case 4:
                url = "https://covid19greece.com/geografiko-diamerisma/thraki";
                break;
            case 5:
                url = "https://covid19greece.com/geografiko-diamerisma/kriti";
                break;
            case 6:
                url = "https://covid19greece.com/geografiko-diamerisma/makedonia";
                break;
            case 7:
                url = "https://covid19greece.com/geografiko-diamerisma/nisia-aigaioy-pelagoys";
                break;
            case 8:
                url = "https://covid19greece.com/geografiko-diamerisma/nisia-ionioy-pelagoys";
                break;
            case 9:
                url = "https://covid19greece.com/geografiko-diamerisma/peloponnisos";
                break;
            case 10:
                url = "https://covid19greece.com/geografiko-diamerisma/sterea-ellada";
                break;
            case 11:
                url = "exit";
            }
        }
        return url;
    }

    // small change to see if it's working
    /**
     * method that opens the websites.
     *
     * @param url : the url to show
     */
    public static void showSite(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}