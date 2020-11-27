package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    
    private String[] mess = new String[5];
    
    public ServerClientThread(Socket inSocket,int counter) {
        serverClient = inSocket;
        clientNo=counter;
    }
    
    public void run() {
        try{
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage="", serverMessage="";
            while(!clientMessage.equals("bye")){
                clientMessage = inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": id ="+clientMessage);

                clientMessage = inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": id ="+clientMessage);
                
                clientMessage = inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": id ="+clientMessage);
                
                clientMessage = inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": id ="+clientMessage);
                
                serverMessage="From Server to Client-" + clientNo + " Ok i have the location";
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
            System.out.println(clientMessage);
        }catch(IOException e) {
        	System.out.println("Client No:" + clientNo + " exit!! ");
        }finally{
        	System.out.println("Connection reset waiting for new Client");
        }
    }
}