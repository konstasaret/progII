/**Shows blue background with an icon and the name of our app up -left.*/

package gr.aueb.dmst.StopSpread;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Evaggelia
 */
public class Frame1 {
  public static void frame() {
    //JFrame = a GUI window to add components to
    JFrame frame = new JFrame();  //creates a frame
    frame.setTitle("Welcome to StopCovidSpread App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application//hide
    frame.setResizable(false);     //prevent frame from being resized
    frame.setSize(5000, 5000);     //sets the x-dimension , and y-dimension of frame
    frame.setVisible(true);        //make frame visible
//  ImageIcon image = new ImageIcon("coronavirus-banner.jpg"); //create an image ImageIcon
//  frame.setIconImage(image.getImage()); //change icon of frame
    frame.getContentPane().setBackground(Color.blue); //change color of background
  }
}