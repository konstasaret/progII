package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ServerClientThread extends Thread {
    
	Socket serverClient;
    int clientNo;
    

    public ServerClientThread(Socket inSocket,int counter){
    	serverClient = inSocket;



        clientNo=counter;
    }
    
    public void run() {
        try{
        	
        	
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            
            String clientMessage="", serverMessage="";

            int count = -1;
            
            while(count != 0) {
            	
	            clientMessage = inStream.readUTF();
	            
	            if (clientMessage.equals("a epilogi")) {
	                count = 1;
	            }else if (clientMessage.equals("b epilogi")) {
	                count = 2;
	            }else if (clientMessage.equals("c epilogi")){
	                count = 3;
	            }
                  
                if (count == 1) {
                	
                	String City = inStream.readUTF();            
                    String Address = inStream.readUTF();                  
                    int arrival_time = Integer.parseInt(inStream.readUTF());                    
                    int departure_time = Integer.parseInt(inStream.readUTF());                   
                    String date = inStream.readUTF();                    
                    int user_id = Integer.parseInt(inStream.readUTF());
                    
                    Database.createConnection();                 
                    Database.insertIntoLocationsTable(City, Address, arrival_time, departure_time, date, user_id);
                    Database.printUserLocations(user_id);
                    Database.shutdownConnection();
                    
                    serverMessage="From Server to Client-" + clientNo + "Ok i have the location";// den mporoume na ton sbhnoume
                    outStream.writeUTF(serverMessage);//prepei na aposindeete kateu8eian
                    outStream.flush();
                }
                if (count == 2) {

                    System.out.println("Πήγενε σε κάποιο νοσοκομείο");

                }
                if (count == 3) {

                    Database.deleteUsersRow(Integer.parseInt(clientMessage));//problhma
                    serverMessage="From Server to Client-" + clientNo + "Ok you are deleted";// den mporoume na ton sbhnoume
                    outStream.writeUTF(serverMessage);//prepei na aposindeete kateu8eian
                    outStream.flush();

                }
                if (count == 4) {

                    Database.printUserLocations(Integer.parseInt(clientMessage)); //problhma kai edo
                    serverMessage="From Server to Client-" + clientNo + "Ok you are deleted";// database ston tcp
                    outStream.writeUTF(serverMessage);
                    outStream.flush();

                }




            }
            
            inStream.close();
            outStream.close();
            serverClient.close();


            
        }catch(IOException e) {
        	System.err.println("Client -" + clientNo + " exit!! ");
        }finally{
            System.out.println("Connection reset waiting for new Client");

        }
    }
}