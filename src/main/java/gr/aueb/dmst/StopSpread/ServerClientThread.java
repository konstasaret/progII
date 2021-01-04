package gr.aueb.dmst.StopSpread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class ServerClientThread extends Thread {

    private Socket socket;
    private int clientNo;

    public ServerClientThread(Socket inSocket, int counter) {
        socket = inSocket;
        clientNo = counter;
    }

    @Override
    public void run() {
        Database db = new Database();
        db.createConnection();// connection with database
        try {
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage, serverMessage;
            int count = -5;

            while (count != 0) {
                clientMessage = inStream.readUTF();
                if (clientMessage.equals("check")) {
                    // connections check
                    count = -3;
                } else if (clientMessage.equals("newuser")) {
                    // new user
                    count = -2;
                } else if (clientMessage.equals("login")) {
                    // log in
                    count = -1;
                } else if (clientMessage.equals("a epilogi")) {
                    // new location
                    count = 1;
                } else if (clientMessage.equals("b epilogi")) {
                    // positive
                    count = 2;
                } else if (clientMessage.equals("c epilogi")) {
                    // delete user
                    count = 3;
                } else if (clientMessage.equals("d epilogi")) {
                    // see locations
                    count = 4;
                } else if (clientMessage.equals("story")) {
                    // stories
                    count = 5;
                } else if (clientMessage.equals("eval")) {
                    // evaluation
                    count = 6;
                } // end of if

                if (count == -3) {
                    // connections check
                    int user_id = inStream.readInt();// get user id
                    boolean infected = db.checkInfected(user_id);

                    outStream.writeBoolean(infected);// pass infected
                    outStream.flush();

                    if (infected == true) {
                        db.restoreInfected(user_id);// restore table
                    }
                } else if (count == -2) {
                    // new user
                    String userName = inStream.readUTF(); // user name from client

                    // check for duplicate user name
                    while (db.usernameCheck(userName)) {
                        serverMessage = "Το Όνομα Χρήστη χρησιμοποιείται ήδη. "
                                + "\nΠαρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη: ";
                        outStream.writeUTF(serverMessage);
                        outStream.flush();

                        userName = inStream.readUTF();// new user name
                    }

                    // check done
                    serverMessage = "Αποδεκτό Ονομα Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();

                    // password from client
                    String pass = inStream.readUTF();

                    // Insertion in table
                    db.insertIntoUserTable(userName, pass);

                } else if (count == -1) {
                    // log in
                    String userName = inStream.readUTF(); // user name from client

                    // user name exists check
                    int user_id = db.findUsersId(userName);
                    while (user_id == -1) {
                        serverMessage = "Αποτυχία Σύνδεσης.\nΤο Όνομα Χρήστη δεν υπάρχει."
                            + "\nΠαρακαλώ προσπαθήστε ξανά : ";
                        outStream.writeUTF(serverMessage);
                        outStream.flush();

                        userName = inStream.readUTF();
                        user_id = db.findUsersId(userName);
                    }
                    // check done
                    serverMessage = "Αποδεκτό Ονομα Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();

                    String pass = inStream.readUTF();// password from client
                    String existingPass = db.findUsersPass(user_id);// password from database

                    // password check
                   while (!existingPass.equals(pass)) {
                       serverMessage = "Αποτυχία Συνδεσης.\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν."
                           + "\nΔοκιμάστε ξανά.\nΠαρακαλώ εισάγετε ξανά τον Κωδικό σας:";
                       outStream.writeUTF(serverMessage);
                       outStream.flush();

                       pass = inStream.readUTF(); // new password
                   }
                   // check done
                   serverMessage = "Αποδεκτός Κωδικός Χρήστη";
                   outStream.writeUTF(serverMessage);
                   outStream.flush();

                   outStream.writeInt(user_id);// returning user id
                   outStream.flush();

                } else if (count == 1) {
                    // new location
                    String city = inStream.readUTF();
                    String address = inStream.readUTF();
                    int arrival_time = inStream.readInt();
                    int departure_time = inStream.readInt();
                    String date = inStream.readUTF();
                    int user_id = inStream.readInt();

                    db.insertIntoLocationsTable(city, address, arrival_time, 
                        departure_time, date, user_id);

                    serverMessage = "Η τοποθεσία σας καταγράφηκε :" + "\n	Πόλη : " + city + "\n	Διεύθυνση : "
                        + address + "\n	Άφιξη : " + arrival_time + ":00" + "\n	Αναχώριση : " + departure_time
                        + ":00" + "\n	Ημερομηνία : " + date;
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
                    
                } else if (count == 2) {
                    // positive
                    int user_id = inStream.readInt();
                    db.findConnections(user_id);
                    serverMessage = "Ευχαριστούμε για την ενημέρωση\n" 
                        + "Θα ειδοποιήσουμε τις πιθανές επαφές σας\n Πηγαίνετε σε κάποιο νοσοκομείο";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();

                } else if (count == 3) {
                    // delete user
                    int user_id = inStream.readInt(); //get user id from client
                    String given_pass = inStream.readUTF(); //get user input password from client
                    String exist_pass = db.findUsersPass(user_id); //user's password

                    // password check
                    while (!given_pass.equals(exist_pass)) {
                        serverMessage = "Ο κωδικός σας δεν ταιριάζει \nΠαρακαλώ δωκιμάστε ξανά :";
                        outStream.writeUTF(serverMessage);
                        outStream.flush();
                        given_pass = inStream.readUTF();
                    }

                    // check done
                    serverMessage = "Αποδεκτός Κωδικός Χρήστη";
                    outStream.writeUTF(serverMessage);
                    outStream.flush();
                    db.deleteUsersRow(user_id);

                } else if (count == 4) {
                    // see locations
                    int user_id = inStream.readInt();// get user id from client
                    ResultSet results = db.userLocationsResult(user_id); // get data
                    
                    try {
                        // An object that can be used to get information about the types and properties
                        // of the columns in a ResultSet object
                        ResultSetMetaData rsmd = results.getMetaData();

                        int numberCols = rsmd.getColumnCount() - 1; //get number of columns 
                                                                    //-1 to exclude user_id
                        outStream.writeInt(numberCols);// sent to client
                        outStream.flush();

                        // sent column names
                        for (int i = 1; i <= numberCols; i++) {
                            outStream.writeUTF(rsmd.getColumnLabel(i));
                        } // end of for

                        while (results.next()) {
                            outStream.writeUTF("more"); //check message
                            outStream.flush();

                            outStream.writeUTF(results.getString(1)); //city
                            outStream.flush();
                            outStream.writeUTF(results.getString(2)); //address
                            outStream.flush();
                            outStream.writeInt(results.getInt(3)); //arrival time
                            outStream.flush();
                            outStream.writeInt(results.getInt(4)); //departure time
                            outStream.flush();
                            outStream.writeUTF(results.getString(5)); //date
                            outStream.flush();
                        }
                        outStream.writeUTF("ok");// check message
                        outStream.flush();
                        results.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else if (count == 5) {
                    clientMessage = inStream.readUTF();
                    int option = 0;
                    if (clientMessage.equals("read story")) {
                        option = 1;
                    } else if (clientMessage.equals("new story")) {
                        option = 2;
                    } else if (clientMessage.equals("exit")) {
                        //will do nothing
                    } //end of if

                    if (option == 1) {
                        ResultSet results = db.getRandomStory();
                        try {
                            results.next();

                            outStream.writeUTF(results.getString(2));
                            outStream.flush();

                            outStream.writeUTF(results.getString(3));
                            outStream.flush();

                            results.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    } else if (option == 2) {
                        String storyTitle = inStream.readUTF();
                        String storyBody = inStream.readUTF();
                        db.insertIntoStoriesTable(storyTitle, storyBody);
                    }

                } else if (count == 6) {
                    clientMessage = inStream.readUTF();
                    int option = 0;
                    
                    if (clientMessage.equals("eval01")) {
                        option = 1;
                    } else if (clientMessage.equals("eval02")) {
                        option = 2;
                    } else if (clientMessage.equals("eval03")) {
                        option = 3;
                    } else if (clientMessage.equals("eval04")) {
                        //will do nothing
                    } //end of if

                    if (option == 1) {
                        int[] Ev = db.getEvaluations();

                        outStream.writeInt(Ev[0]);
                        outStream.flush();
                        outStream.writeInt(Ev[1]);
                        outStream.flush();
                        outStream.writeInt(Ev[2]);
                        outStream.flush();
                        outStream.writeInt(Ev[3]);
                        outStream.flush();
                        outStream.writeInt(Ev[4]);
                        outStream.flush();
                    } else if (option == 2) {
                        int choice = inStream.readInt();
                        db.insertIntoEvaluationTable(choice);
                    } else if (option == 3) {

                        String sxolioXristi = inStream.readUTF();
                        db.insterIntoEvalComments(sxolioXristi);

                    }
                } // end of if
            } // end of while

            inStream.close();
            outStream.close();
            socket.close();

        } catch (IOException e) {
            System.err.println("Client -" + clientNo + " exit!! ");
        } finally {
            System.out.println("Connection reset waiting for new Client");
            db.shutdownConnection();
        } //end of try-catch
        
    }//end of run()

}//end of class