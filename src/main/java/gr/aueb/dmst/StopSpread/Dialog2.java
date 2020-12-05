package gr.aueb.dmst.StopSpread;

/**dialog input with a dialog box */

/**import class JOptionPane*/
import javax.swing.JOptionPane;

public class Dialog2
{
	public  void  Dialog2Boxes()
	{
		/**promt user to enter the name*/
		String name =
			JOptionPane.showInputDialog("Insert your code");

			/**create the message*/
			String message =
				String.format(" Welcome to our app");

			/**display the message user's code */
			JOptionPane.showMessageDialog(null,message);
	}//ending of Dialog2Boxes
} //ending of Dialog2
