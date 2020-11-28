package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.util.ArrayList;

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
            String clientMessage="", serverMessage="", perioxi = null, meros = null, startTime = null, endTime = null, id = null;
            ArrayList<String> locationData = new ArrayList<String>();
            int count = 0;
            while(!clientMessage.equals("bye")){
                clientMessage=inStream.readUTF();

                // h epilogi orizei to count kai me auto sinexizoyme meta
                if (clientMessage == "a epilogi") {

                    count = 1;

                }else if (clientMessage == "b epilogi"){

                    count = 2;

                }
                // xekiname me to count tora kai thn epilogi a

                if (count == 1 && clientMessage != "a epilogi"){

                    locationData.add(clientMessage);

                }


                System.out.println("From Client-" +clientNo+ ": Location is :"+clientMessage + count);
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