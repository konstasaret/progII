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
            
        	Database.createConnection();//connection with database

            while(count != 0) {
            	
	            clientMessage = inStream.readUTF();
	            
	            if (clientMessage.equals("a epilogi")) {
	                count = 1;
	            }else if (clientMessage.equals("b epilogi")) {
	                count = 2;
	            }else if (clientMessage.equals("c epilogi")){
	                count = 3;
	            }else if (clientMessage.equals("login")) {
	                count = -1;
                }else if (clientMessage.equals("newuser")) {
	                count = -2;
                }
	            

                if (count == -2) {
                   
                    String userName = inStream.readUTF();//user name from client
 
                    //check for duplicate user name 
                    while (Database.usernameCheck(userName)){
                        serverMessage="Το Όνομα Χρήστη χρησιμοποιείται ήδη. \nΠαρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη: ";
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                        
                        userName = inStream.readUTF();//new user name 
                    } 
                    
                    //check done
                    serverMessage="Αποδεκτό Ονομα Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
                    
                    //password from client
                    String pass = inStream.readUTF();
                    
                    //Insertion in table 
                    Database.insertIntoUserTable(userName, pass);

                }else if (count == -1) {

                	String userName = inStream.readUTF();//user name from client
                	
                	//user name exists check
            		int user_id = Database.findUsersId(userName);
            		while (user_id == -1) {
            			serverMessage="Αποτυχία Σύνδεσης.\nΤο Όνομα Χρήστη δεν υπάρχει.\nΠαρακαλώ προσπαθήστε ξανά : ";
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                        
            			userName = inStream.readUTF();
            			user_id = Database.findUsersId(userName);
            		}
            		//check done
                    serverMessage="Αποδεκτό Ονομα Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
                    
                    
                    String pass = inStream.readUTF();//password from client
            		String existingPass = Database.findUsersPass(user_id);//password from database

            		//password check
            		while(!existingPass.equals(pass)) {
            			serverMessage = "Αποτυχία Συνδεσης.\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν.\nΔοκιμάστε ξανά.\nΠαρακαλώ εισάγετε ξανά τον Κωδικό σας:";
            			outStream.writeUTF(serverMessage);
            			outStream.flush();
            			
            			pass = inStream.readUTF();// new password
            		}
            		//check done
                    serverMessage="Αποδεκτός Κωδικός Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
            		
            		outStream.writeInt(user_id);//returning user id
            		outStream.flush();
            		

                }else if (count == 1) {
                	
                	String city = inStream.readUTF();            
                    String address = inStream.readUTF();                  
                    int arrival_time = inStream.readInt();                   
                    int departure_time = inStream.readInt();                     
                    String date = inStream.readUTF();                    
                    int user_id = inStream.readInt();   
                    
                    Database.createConnection();                 
                    Database.insertIntoLocationsTable(city, address, arrival_time, departure_time, date, user_id);
                    Database.shutdownConnection();
                    
                    serverMessage = "Η τοποθεσία σας καταγράφηκε :"
                    		+ "\n	Πόλη : " + city 
                    		+ "\n	Διεύθυνση : " + address
                    		+ "\n	Άφιξη : " + arrival_time + ":00"
                    		+ "\n	Αναχώριση : " + departure_time + ":00"
                    		+ "\n	Ημερομηνία : " + date;
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
                }else if (count == 2) {

                    System.out.println("Πήγενε σε κάποιο νοσοκομείο");

                }else if (count == 3) {
                	int user_id = inStream.readInt();//get user id from client

                	String given_pass = inStream.readUTF();//get user input password from client
                	Database.createConnection();
            		String exist_pass = Database.findUsersPass(user_id);//user's password
                	
            		//password check
            		while (!given_pass.equals(exist_pass)) {
            			serverMessage = "Ο κωδικός σας δεν ταιριάζει \nΠαρακαλώ δωκιμάστε ξανά :";
            			outStream.writeUTF(serverMessage);
            			outStream.flush();
            			
            			given_pass = inStream.readUTF();
            			
            		}
            		
            		//check done
                	serverMessage = "Αποδεκτός Κωδικός Χρήστη";
                	outStream.writeUTF(serverMessage);
                	outStream.flush();
                	
                    Database.deleteUsersRow(user_id);
                   
                }else if (count == 4) {

                    Database.printUserLocations(Integer.parseInt(clientMessage)); //problhma kai edo
                    serverMessage="From Server to Client-" + clientNo + "Ok you are deleted";// database ston tcp
                    outStream.writeUTF(serverMessage);
                    outStream.flush();

                }


            }
            
            Database.shutdownConnection();

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