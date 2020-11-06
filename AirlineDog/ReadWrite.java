package AirlineDog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadWrite {
	
	public static ArrayList<String> read(String file) {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			FileInputStream fis =  new FileInputStream(file) ;
					ObjectInputStream ois =  new ObjectInputStream(fis) ;
					arr = (ArrayList) ois.readObject() ;
					ois.close() ;
			}catch(Exception e) {
				System.err.println("err read");
			}
		return arr;
	}
	
	public static void write(ArrayList<String> arr, String file) {
			try {
				FileOutputStream fos =  new FileOutputStream(file) ;
				ObjectOutputStream oos =  new ObjectOutputStream(fos) ;
				oos.writeObject(arr);
				oos.close() ;
			}catch(Exception e){
				System.err.println("err write");
			}
	}
}
