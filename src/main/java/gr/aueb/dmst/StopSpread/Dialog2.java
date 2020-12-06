package gr.aueb.dmst.StopSpread;

/**import class JOptionPane*/
import javax.swing.JOptionPane;

/**dialog input with a dialog box */
public class Dialog2
{
	public  void  Dialog2Boxes()
	{
		/**promt user to enter the name*/
		String name =
			JOptionPane.showInputDialog("Enter your password:");

			/**create the message*/
			String message =
				String.format(" Welcome to our app!");

			/**display the message user's code */
			JOptionPane.showMessageDialog(null,message);
	}//ending of Dialog2Boxes
} //ending of Dialog2
