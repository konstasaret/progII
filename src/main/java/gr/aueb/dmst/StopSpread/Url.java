package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class which succeeds the redirect to browser and opens web page
 */
public class Url {
	/**
	 * Opens website on user's search machine.
	 * @param url : the ULR to show
	 */
	public static void openUrl(String url) {
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException e) {
			Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, e);
		}
	} // end of method openUrl
} // end of Class Url
