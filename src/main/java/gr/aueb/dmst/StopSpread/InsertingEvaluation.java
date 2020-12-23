package gr.aueb.dmst.StopSpread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**Class InsertingEvaluation asks from
the user to evaluate the app and user can see
the existing evaluation*/

public class InsertingEvaluation {
  //private memembers of the class
  /**counts the users who vote 1 = πολύ κακή εφαρμογή.*/
  private static int mark1;
  
  /**counts the users who vote 2 = κακή εφαρμογή.*/
  private static int mark2;
  
  /**counts the users who vote 3 = μέτρια εφαρμογή.*/
  private static int mark3;
  
  /**counts the users who vote 4 = καλή εφαρμογή.*/
  private static int mark4;
  
  /**counts the users who vote 5 = πολύ καλή εφαρμογή.*/
  private static int mark5;
  
  /**counts the total users who evaluate our StopCovidSpread app.*/
  private static int totalusers;
  
  /**holds the maximum among mark1, mark2, mark3, mark4.*/
  private static int storeMax1;
  
  /**create table that stores the number of each mark.*/
  static int[] markarray = new int[5];
  
  /**create a list that stores the critic of user's app.*/
  ArrayList<String> list  = new ArrayList<String>();
  
  /**users enter their evaluation.*/
  public void insertEvaluation() { //beginning of insertEvaluation method
    try{
      //server-client messages
      DataOutputStream outStream = TCPClient.getOutStream();
      String clientMessage;

      //for option identification
      clientMessage = "eval";
      outStream.writeUTF(clientMessage);
      outStream.flush();
      Menus mn = new Menus();
      int choice;

      //calling the menu of class Menus via the Object mn
      mn.insertMenu();
      choice = Inputs.rangeInt(1, 5);
      //each variable of mark1,..3,2..,5 counts how many vote have  each choice(1,2,3,4,5)
      outStream.writeInt(choice);
      outStream.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**Prints the existing evaluation.*/
  public void printEvaluation() {
    System.out.printf("%d : άτομα ψήφισαν πολύ κακή εφαρμογή\n", mark1);
    System.out.printf("%d : άτομα ψήφισαν κακή εφαρμογή\n", mark2);
    System.out.printf("%d : άτομα ψήφισαν μέτρια εφαρμογή\n", mark3);
    System.out.printf("%d : άτομα ψήφισαν καλή εφαρμογή\n", mark4);
    System.out.printf("%d : άτομα ψήφισαν πολύ καλή εφαρμογή\n", mark4);
    System.out.printf("%d : συνολικά ψήφισαν\n", totalusers);
  }
  /**Prints the evaluation which dominates. */
  /**Prints graph - rabdogramma of evaluation. */
  
  public void printRabdogramma() { //beginning of Rabdogramma
    System.out.printf("Πολύ κακή εφαρμογή : ");
    for (int stars = 0; stars < markarray[0]; stars++) { //beginning of loop
      System.out.print("*"); //prints stars
    } //end of loop0
    System.out.println();
    System.out.printf("Kακή εφαρμογή : ");
    for (int stars = 0; stars < markarray[1]; stars++) { //beginning of loop
      System.out.print("*"); //prints stars
    } //end of loop1
    System.out.println();
    System.out.printf("Μέτρια εφαρμογή : ");
    for (int stars = 0; stars < markarray[2]; stars++) { //beginning of loop
      System.out.print("*"); //prints stars
    } //end of loop2
    System.out.println();
    System.out.printf("Καλή εφαρμογή : ");
    for (int stars = 0; stars < markarray[3]; stars++) { //beggining of loop
      System.out.print("*"); //prints stars
    } //end of loop3
    System.out.println();
    System.out.printf("Πολύ καλή εφαρμογή : ");
    for (int stars = 0; stars < markarray[4]; stars++) { //beginning of loop
      System.out.print("*"); //prints stars
    } //end of loop4
    System.out.println();
  } //ending of method printRabdogramma
  
  public void printDomination() {
    markarray[0] = InsertingEvaluation.mark1;
    markarray[1] = InsertingEvaluation.mark2;
    markarray[2] = InsertingEvaluation.mark3;
    markarray[3] = InsertingEvaluation.mark4;
    markarray[4] = InsertingEvaluation.mark5;
    /**sort the elements of the array asc*/
    Arrays.sort(markarray);
    System.out.println();
    //stores in markarray[3] the maximum element
    storeMax1 = markarray[3];
    System.out.println("Η Γενική Κριτική για την εφαρμογή  είναι: ");
    if (mark1 == storeMax1) {
      System.out.println("Η εφαρμογή είναι πολύ κακή");
    }
    if (mark2 == storeMax1) {
      System.out.println("Η εφαρμογή είναι κακή");
    }
    if (mark3 == storeMax1) {
      System.out.println("Η εφαρμογή είναι μέτρια");
    }
    if (mark4 == storeMax1) {
      System.out.println("Η εφαρμογή είναι καλή");
    }
    if (mark5 == storeMax1) {
      System.out.println("Η εφαρμογή είναι πολύ καλή");
    }
  } //end printDomination
	
  /**Users write their evaluation about our app.*/
  public void reasonOfEvaluation() {
    Inputs inp = new Inputs();
    Scanner sc5 = new Scanner(System.in);
    System.out.println("Επιθυμείτε να προσθέσετε σχόλια για την εφαρμογή StopSpread;");
    //interaction with the user
    System.out.println("1. ΝΑΙ");
    System.out.println("2. ΟΧΙ");
    int check = Inputs.rangeInt(1, 2);
    if (check == 1) {
      System.out.print("Μπορείτε να πληκτρολογήσετε το σχόλιο σας: ");
      String sxolia = sc5.next();
      list.add(sxolia);
      System.out.print("Σας Ευχαριστούμε, η κριτική σας μόλις καταχωρήθηκε!");
    } else {
      System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας!");
    }
    sc5.close();
  }
}