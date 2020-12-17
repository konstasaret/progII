package gr.aueb.dmst.StopSpread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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

    	Profile prof = new Profile();
    	Menus menu = new Menus();
        try{

            socket = new Socket("127.0.0.1",8888);

            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";
            String Number = "";

            while(!clientMessage.equals("yes")){
            	int user_id = 0;
            	while(user_id == 0) {
            		menu.logInMenu();
                    int logg = Inputs.rangeInt(1, 2);
                    if (logg == 1) {
                    	//Σύνδεση
                    	user_id = prof.authenticate();
                    } else if (logg == 2) {
                    	//Νέος Χρήστης
                    	prof.newEntry();
                    }
            	}

            	//ελεγχος επαφών
            	prof.checkConnections(user_id);

                int option;
                while (!Number.equals("7")) {
                    menu.firstMenu(user_id);
                    option = Inputs.rangeInt(1, 6);

                    if (option == 1) {
                        //Προσθήκη τοποθεσίας
                        prof.newLocation(user_id);
                    } else if (option == 2) {
                        //θετικός
                        prof.infected(user_id);

                    } else if (option == 3) {
                        //διαγραφή
                        prof.deleteUser(user_id);
                        Number = "7";
                    } else if (option == 4) {
                        //τοποθεσίες
                        prof.seeLocations(user_id);
                    }else if (option == 5){
                        //στατιστικα
                        GSX.gsxToTCP();
                    }else if (option == 6) {
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

