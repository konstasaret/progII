package gr.aueb.dmst.StopSpread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Starting server Class.
 *
 */
public class MultithreadedSocketServer {
  /**
   * Starts Server
   * 
   * @param args
   * @throws IOException
   */
  
  public static void main(String[] args) {
    try {
	    ServerSocket server = new ServerSocket(8888);
	    int counter = 0;
	    System.out.println("Server Started ....");
	    while (true) {
	        counter++;
            Socket serverClient = server.accept(); // server accept the client connection request
	        System.out.println(">> " + "Client No:" + counter + " started!");
            ServerClientThread sct = new ServerClientThread(serverClient, counter); // send the request to a
                                                                                    // separate
                                                                                    // thread
	        sct.start();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

  }
}