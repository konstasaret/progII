package AirlineDog;

public class Main {

	public static void main(String[] args) {
		Profile prof = new Profile();
		prof.newEntry();
		prof.newEntry();
		
		ReadWrite.write(prof.getID(),"ID.txt");
		ReadWrite.write(prof.getUser_name(),"User.txt");
		ReadWrite.write(prof.getPassword(),"Pass.txt");
		ReadWrite.write(prof.getAddress(),"Address.txt");

		prof.setID(ReadWrite.read("ID.txt"));
		prof.setUser_name(ReadWrite.read("User.txt"));
		prof.setPassword(ReadWrite.read("Pass.txt"));
		prof.setAddress(ReadWrite.read("Address.txt"));
		System.out.println(prof.getID());
		System.out.println(prof.getUser_name());
		System.out.println(prof.getPassword());
		System.out.println(prof.getAddress());

	}


}
