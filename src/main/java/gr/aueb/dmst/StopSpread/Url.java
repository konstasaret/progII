package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author user
 * A class which succeeds the
 * redirect to browser and opens 
 * web page
 */
public class Url{
	public static void main(String[] args) {
		String url_open ="https://www.google.gr/?hl=el";
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
		} catch (IOException ex) {
			Logger.getLogger(Url.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
