package gr.aueb.dmst.StopSpread;

/**
 * This class shows the statistics and graphs per area.
 * (Attiki,Ipiros,Thesalsaloniki, Thraki,Kriti,Makedonia,Nisia Ioniou, Nisia
 * Aigeou,Sterea Ellada,Peloponnisos)
 */
public class GreekStats {

    /**
     * This method prints the appropriate menu, reads an integer from user which is
     * his/her choice and opens the suitable web site each time.
     */
    public void greekStats() {
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
                    Url.openUrl(url);
                } else if (choice == 2) {
                    while (true) {
                        menu.greekStatsMenu2();
                        option = inp.rangeInt(1, 11);

                        String url = decideURL(choice, option);
                        if (!url.equals("exit"))
                            Url.openUrl(url);
                        else
                            break;
                    } // end of loop
                } else if (choice == 3) {
                    String url = decideURL(choice, 0);
                    Url.openUrl(url);
                }

                menu.greekStatsMenu();
                choice = inp.rangeInt(1, 4);
            }
            contloop = false;
        } while (contloop);
    }

    /**
     * Selects the desired URL
     * @param choice
     * @param NomosOption
     * @return the URL
     */
    public String decideURL(int choice, int NomosOption) {
        String url = "";

        if (choice == 1)
            url = "https://covid19.gov.gr/covid19-live-analytics/";
        else if (choice == 3)
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

}
