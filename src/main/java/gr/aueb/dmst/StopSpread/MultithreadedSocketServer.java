package gr.aueb.dmst.StopSpread;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

/**
 * @author kostasaret
 *
 */
public class MultithreadedSocketServer {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);

            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(">> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                sct.start();
            }
        }catch(SocketException e){
            
        }
    }
}

