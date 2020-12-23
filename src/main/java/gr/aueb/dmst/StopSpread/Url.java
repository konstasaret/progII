package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** A class which succeeds the
 * redirect to browser and opens 
 * web page
 */


public class Url {
  /**
  *Opens website on user's search machine.
  */
  public static void openUrl() {
    String url = "https://www.google.gr/?hl=el";
    try {
      java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    } catch (IOException ex) {
      Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
