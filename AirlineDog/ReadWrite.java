package AirlineDog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadWrite {
	
	public static void read() {
		
	}
	
	public static void write() {
		try {
			FileWriter writer = new FileWriter("Hello.txt"); 
			for(int i = 0; i<Profile.profs.size();i++ ) {
				writer.write(Profile.profs.get(i).getAddress() + System.lineSeparator());
			}
			writer.close();
			}catch (IOException e) {
				System.err.println("error");
			}finally {
				System.out.println("created");
			}
	}
	private static FileOutputStream fs ;
	private static ObjectOutputStream os;
	public static void heloo() {
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    cars.add("papap");
			try {
				FileOutputStream fos =  new FileOutputStream("test.txt") ;
				fs=fos;
				ObjectOutputStream oos =  new ObjectOutputStream(fos) ;
				oos.writeObject(cars);
				oos.close() ;
			}catch(Exception e){
				System.err.println("err cars");
			}
	}
	public static void bye() {
		try {
		FileInputStream fis =  new FileInputStream("test.txt") ;
				ObjectInputStream ois =  new ObjectInputStream(fis) ;
				ArrayList<String> cars = (ArrayList) ois.readObject() ;
				ois.close() ;
				System.out.println(cars);
		}catch(Exception e) {
			System.err.println("err bye");
		}
	}
}
