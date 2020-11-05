import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Profile.NewEntry();
		System.out.println(Profile.profs.get(0).getUser_name());
		Profile.NewEntry();
		System.out.println(Profile.profs.get(0).getUser_name());
		System.out.println(Profile.profs.get(1).getUser_name());
	
		Profile.file();
	}
	
	public void log_in() {
		Scanner in = new Scanner(System.in);
		System.out.println("username");
		
		
	}

}
