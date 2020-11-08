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
            String logg ="";
            Scanner scanner = new Scanner(System.in);
            Profile pro = new Profile();
            String userid = "";

            while(!clientMessage.equals("yes")){
                do{
                	Scanner logsc = new Scanner(System.in);
                    System.out.println("1.Log in \n 2.Sing up \n");
                    logg = logsc.nextLine();
                    if (logg.equals("2")) {
                        userid = pro.newEntry();
                        //edo prepei na exoyme kai ta id tous giati panta etsi 8a tous briskoume kai otan stelnoun kati ston server prepei na phgainei kai auto mazi
                    } else if (logg.equals("1")) {
                        userid = pro.authenticate();
                        //edo prepei na exoyme kai ta id tous giati panta etsi 8a tous briskoume kai otan stelnoun kati ston server prepei na phgainei kai auto mazi

                    }
                }while (logg.equals("1") || logg.equals("2")) ;
                    
                

                while (!Number.equals("7")){

                    System.out.println("Menu: \n 1.share location \n 2.Read a story \n");
                    Number = scanner.nextLine();

                    if (Number.equals("1")) {
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
            System.out.println(e);
        }
    }
}

