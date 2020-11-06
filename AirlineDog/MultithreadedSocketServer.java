package AirlineDog;

import java.net.*;
import java.io.*;
public class MultithreadedSocketServer {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);
            Profile profile = new Profile();

            profile.setID(ReadWrite.read("ID.txt"));
            profile.setUser_name(ReadWrite.read("User.txt"));
            profile.setPassword(ReadWrite.read("Pass.txt"));
            profile.setAddress(ReadWrite.read("Address.txt"));

            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

