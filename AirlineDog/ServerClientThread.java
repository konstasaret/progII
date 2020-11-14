package AirlineDog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    
    public ServerClientThread(Socket inSocket,int counter){
        serverClient = inSocket;
        clientNo=counter;
    }
    
    public void run(){
        try{
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage="", serverMessage="";
            while(!clientMessage.equals("bye")){
                clientMessage=inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": Location is :"+clientMessage);
                serverMessage="From Server to Client-" + clientNo + "Ok i have the location";
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
System.out.println(clientMessage);


        }catch(EOFException e){
            
        }catch(Exception e) {
        	e.printStackTrace();
        }finally{
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}