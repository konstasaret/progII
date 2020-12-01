package gr.aueb.dmst.StopSpread;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author kostasaret
 *
 */
public class TCPClient {
	
    /**
     * Begins User's Interface
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        try{
            Socket socket=new Socket("127.0.0.1",8888);

            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "",serverMessage = "";
            String Number = "";
            
            while(!clientMessage.equals("yes")){
            	int user_id = 0;
            	while(user_id == 0) {
            		Menus.firstMenu();
                    int logg = Inputs.rangeInt(1, 2);
                    if (logg == 1) {
                    	//Σύνδεση 
                    	user_id = Profile.authenticate();
                    } else if (logg == 2) {
                    	//Νέος Χρήστης
                    	Profile.newEntry();
                    }
            	}
            	
                	
                
               
                    
                
                int option;
                while (!Number.equals("7")){
                	Menus.logInMenu(user_id);
                	option = Inputs.rangeInt(1, 4);

                    if (option == 1) {
                    	//Προσθήκη τοποθεσίας
                    	System.out.println("Παρακαλούμε εισάγετε τα στοιχεία της τοποθεσίας που επισκευθήκατε :");
                        System.out.println("Εισάγετε την περιοχή :");
                        String perioxi = Inputs.stringScanner();

                        System.out.println("Εισάγετε την διεύθηνση :");
                        String odos = Inputs.stringScanner();

                        System.out.println("Εισάγετε την ώρα άφιξης, στρογγυλοποιημένη στον προηγούμενο ακαίρεο :");
                        int arrtime = Inputs.rangeInt(1,24);

                        System.out.println("Εισάγετε την ώρα αναχώρησης, στρογγυλοποιημένη στον επόμενο ακαίρεο :");
                        int endtime = Inputs.rangeInt(1,24);
                        while (endtime <= arrtime) {
                        	System.err.println("Παρακαλούμε εισάγετε ώρα μεγαλύτερη απο την ώρα άφιξης :");
                            endtime = Inputs.rangeInt(1,24);
                        }

                        System.out.println("Εισάγετε την ημερομηνία της επίσεψής σας (ΥΥΥΥ-MM-DD) :");
                        String date = Inputs.stringScanner();
                        
                        clientMessage= "a epilogi";
                        outStream.writeUTF(clientMessage);
                        outStream.flush();

                        clientMessage= perioxi;
                        outStream.writeUTF(clientMessage);
                        outStream.flush();

                        clientMessage = odos;
                        outStream.writeUTF(clientMessage);
                        outStream.flush();

                        clientMessage = Integer.toString(arrtime);
                        outStream.writeUTF(clientMessage);
                        outStream.flush();

                        clientMessage = Integer.toString(endtime);
                        outStream.writeUTF(clientMessage);
                        outStream.flush();
                        
                        clientMessage = date;
                        outStream.writeUTF(clientMessage);
                        outStream.flush();
                        
                        clientMessage = Integer.toString(user_id);
                        outStream.writeUTF(clientMessage);
                        outStream.flush();
                        
                        serverMessage=inStream.readUTF();
                        System.out.println(serverMessage);


                    } else if (option == 2){
                    	//θετικός


                    }else if (option == 3) {
                    	//διαγραφή
                    	Profile.deleteUser(user_id);
                    	System.exit(0);
                    }else if (option == 4) {
                    	//τοποθεσίες
                    	Profile.seeLocations(user_id);
                    	
                    }
                    clientMessage = "to id tou user";
                    outStream.writeUTF(clientMessage);
                    outStream.flush();

                }

                System.out.println("Are you sure yes/no");
                Scanner quitsc = new Scanner(System.in);
                clientMessage=br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                quitsc.close();
            }

            outStream.close();
            outStream.close();
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

