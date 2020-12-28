package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A class where the user can read stories of patients and/or write and send his
 * own story
 */

public class Stories {

	private TCPClient cl = new TCPClient();

	/**
	 * The main method of the class Prints user's menu User reads or/and creates his
	 * own story Exits when user types "3"
	 */
	public void stories() {
		Menus menu = new Menus();
		Inputs inp = new Inputs();

		// server-client messages
		DataOutputStream outStream = cl.getOutStream();
		DataInputStream inStream = cl.getInStream();
		String clientMessage;
		while (true) {
			try {
				// for option identification
				clientMessage = "story";
				outStream.writeUTF(clientMessage);
				outStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			menu.storiesMenu();
			int ch = inp.rangeInt(1, 3);
			if (ch == 1) {
				try {

					// for option identification
					clientMessage = "read story";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					String title = inStream.readUTF();
					String body = inStream.readUTF();

					System.out.println(title);
					System.out.println(body);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (ch == 2) {
				try {

					// for option identification
					clientMessage = "new story";
					outStream.writeUTF(clientMessage);
					outStream.flush();

					System.out.println("Πληκτρολογήστε τον τίτλο της ιστορίας σας:");
					String storyTitle = inp.stringScanner();

					System.out.println("Πληκτρολογήστε την ιστορία σας:");
					String storyBody = inp.stringScanner();

					System.out.println("Σας ευχαριστούμε πολύ!");

					outStream.writeUTF(storyTitle);
					outStream.flush();
					outStream.writeUTF(storyBody);
					outStream.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ch == 3) {
				break;
			}

		}

		// sc1.close();
	}
}
