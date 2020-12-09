package gr.aueb.dmst.StopSpread;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author kostasaret
 *
 */
public class TCPClient {

	private static Socket socket;
	private static BufferedReader br;
    private static DataInputStream inStream;
    private static DataOutputStream outStream;

	/**
	 * @return the inStream
	 */
	public static DataInputStream getInStream() {
		return inStream;
	}


	/**
	 * @return the outStream
	 */
	public static DataOutputStream getOutStream() {
		return outStream;
	}
	
    /**
     * Begins User's Interface
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        try{

            socket = new Socket("127.0.0.1",8888);

            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "",serverMessage = "";
            String Number = "";
            
            while(!clientMessage.equals("yes")){
            	int user_id = 0;
            	while(user_id == 0) {
            		Menus.logInMenu();
                    int logg = Inputs.rangeInt(1, 2);
                    if (logg == 1) {
                    	//Σύνδεση 
                    	user_id = Profile.authenticate();
                    } else if (logg == 2) {
                    	//Νέος Χρήστης
                    	Profile.newEntry();
                    }
            	}
            	
            	//ελεγχος επαφών
            	Profile.checkConnections(user_id);
                
                int option;
                while (!Number.equals("7")){
                	Menus.firstMenu(user_id);
                	option = Inputs.rangeInt(1, 5);

                    if (option == 1) {
                    	//Προσθήκη τοποθεσίας
                    	Profile.newLocation(user_id);
                    } else if (option == 2){
                    	//θετικός
                    	Profile.infected(user_id);

                    }else if (option == 3) {
                    	//διαγραφή
                    	Profile.deleteUser(user_id);
                    	Number = "7";
                    }else if (option == 4) {
                    	//τοποθεσίες
                    	Profile.seeLocations(user_id);
                    	
                    }else if (option == 5) {
                    	System.out.println("Λυπούμαστε που φεύγετε");
                    	Number = "7";
                    }
                    

                }

                System.out.println("Are you sure yes/no");
                clientMessage=br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
            }

            outStream.close();
            outStream.close();
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

