package AirlineDog;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        try{
            Socket socket=new Socket("127.0.0.1",8888);

            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";
            String Number ="";
            String userid = "";
            
            while(!clientMessage.equals("yes")){
                	
            	Menu.firstMenu();
                int logg = Inputs.rangeInt(1, 2);
                	
                if (logg == 2) {
                	Profile.newEntry();   
                } else if (logg == 1) {
                	Profile.authenticate();
                }
                    
                
                int option;
                while (!Number.equals("7")){
                	Menu.logInMenu("1");
                	option = Inputs.rangeInt(1, 2);

                    if (option == 1) {
                        clientMessage=br.readLine();
                        outStream.writeUTF(clientMessage);
                        outStream.flush();
                        serverMessage=inStream.readUTF();
                        System.out.println(serverMessage);
                    }
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

