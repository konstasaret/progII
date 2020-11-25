package gr.aueb.dmst.StopSpread;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author kostasaret
 *
 */
public class TCPClient {
	
    public static void main(String[] args) throws Exception {
        try{
            Socket socket=new Socket("127.0.0.1",8888);

            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";
            String Number ="";
            
            while(!clientMessage.equals("yes")){
            	int user_id = 0;
            	while(user_id == 0) {
            		Menus.firstMenu();
                    int logg = Inputs.rangeInt(1, 2);
                    if (logg == 1) {
                    	user_id = Profile.authenticate();
                    } else if (logg == 2) {
                    	Profile.newEntry();
                    }
            	}
            	
                	
                
               
                    
                
                int option;
                while (!Number.equals("7")){
                	Menus.logInMenu(user_id);
                	option = Inputs.rangeInt(1, 3);

                    if (option == 1) {
                    	//kane methodo sthn profile mh  ta exeis ola xyma
                        System.out.println("Βάλτε μας την περιοχή που επισκεφθήκατε π.χ παγκρατι");
                        String perioxi = Inputs.stringScanner();

                        System.out.println("Βάλτε την διεύθηνση π.χ αν ειναι σπίτι εκφαντιδου_7 | αν ειναι καταστημα ΑΒ_βασιλοπουλος  σε καθε κενο βαλτε \"_\"");
                        String odos = Inputs.stringScanner();

                        System.out.println("Βάλτε την ώρα που φτάσατε, με το 24ωρο συστημα και στρογγυλοποιηστε την ωρα σας π.χ 17 = 17:00,17:05....17:30...17:59");
                        int arrtime = Inputs.rangeInt(1,24);

                        System.out.println("Βάλτε την ώρα που φτάσατε, με το 24ωρο συστημα και στρογγυλοποιηστε την ωρα σας π.χ 17 = 17:00,17:05....17:30...17:59");
                        int endtime = Inputs.rangeInt(1,24);

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

                        serverMessage=inStream.readUTF();
                        System.out.println(serverMessage);


                    } else if (option == 2){



                    }else if (option == 3) {
                    	Profile.deleteUser(user_id);
                    	System.exit(0);
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

