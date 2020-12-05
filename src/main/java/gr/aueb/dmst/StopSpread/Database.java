package gr.aueb.dmst.StopSpread;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author alexd
 *Database handing class
 */
public class Database {

	private static final String dbURL = "jdbc:derby:derbyDB;create=true";
	
	private static Connection conn = null;
    private static Statement stmt = null;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	createConnection();

    	/*deleteTables();
    	createUsersTable();
    	createLocationsTable();
    	insertIntoUserTable("AirlineDog", "Salami");
    	insertIntoUserTable("Kostakis", "Makaronia");
    	insertIntoUserTable("Vik", "Pastitsio");
    	insertIntoUserTable("Vagelio", "Password");
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-9-15", 1);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-11-25", 1);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 20, 22,"2020-11-30", 1);
    	
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-9-15", 2);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-11-26", 2);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 19, 21,"2020-11-30", 2);
    	
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-9-15", 3);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 14, 15,"2020-11-25", 3);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 15, 17,"2020-11-25", 3);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-11-29", 3);
    	
    	insertIntoLocationsTable("PAIANIA","STAMOY", 13, 15,"2020-9-15", 4);
    	insertIntoLocationsTable("PAIANIA","THEOTOKOY", 13, 15,"2020-11-25", 4);
    	insertIntoLocationsTable("PAIANIA","STAMOY", 19, 20,"2020-11-30", 4);*/
    	
    	//deleteUsersRow();

    	//printUsersTable();
    	//printLocationsTable();
    	//System.out.println(findConnections(1));
    	
    	shutdownConnection();    
    }
	

    
    /**Initiates connection with the database*/
    public static void createConnection() {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	            //System.out.println("Database connection created");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
    
    
	/**Terminates connection with the database*/
	public static void shutdownConnection() {
		try {
            // the shutdown=true attribute shuts down Derby
			DriverManager.getConnection("jdbc:derby:;shutdown=true");

			if (stmt != null) {
			    stmt.close();
			}
			if (conn != null) {
			    conn.close();
			}     
		}catch (SQLException e) {
			if (( (e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()) ))) {
                // we got the expected exception
                //System.out.println("Derby shut down normally");
            } else {
                // if the error code or SQLState is different, we have
                // an unexpected exception (shutdown failed)
                System.err.println("Derby did not shut down normally");
                e.printStackTrace();
            }
			//System.out.println("database shutdown");
	    }
	}
	
	
	
	
    /**Creates Table of users with columns USER_ID, USER_NAME, PASSWORD*/
    public static void createUsersTable() {
		 try {
			 stmt = conn.createStatement();
			 stmt.execute("CREATE TABLE USERS("
			 		+ "USER_ID INT NOT NULL,"
			 		+ "USER_NAME VARCHAR(255),"
			 		+ "PASSWORD VARCHAR(30),"
			 		+ "PRIMARY KEY (USER_ID) )");
			 stmt.close();
		 }catch(SQLException e ) {
			 e.printStackTrace();
		 }
	 }
    
    /**Creates Table of user's Locations with columns CITY, ADDRESS, ARRIVAL_TIME,
     * DEPARTURE_TIME, USER_ID*/
    public static void createLocationsTable() {
		 try {
			 stmt = conn.createStatement();
			 stmt.execute("CREATE TABLE LOCATIONS("
			 		+ "CITY VARCHAR(255),"
			 		+ "ADDRESS VARCHAR(255),"
			 		+ "ARRIVAL_TIME INT,"
			 		+ "DEPARTURE_TIME INT,"
			 		+ "DAY DATE,"
			 		+ "USER_ID INT,"
			 		+ "FOREIGN KEY (USER_ID) REFERENCES USERS ON DELETE CASCADE)");
			 stmt.close();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }
    
    
    /**Deletes the users and locations tables*/
    public static void deleteTables() {
    	try {
    		stmt = conn.createStatement();
    		stmt.execute("DROP TABLE LOCATIONS ");
    		stmt.execute("DROP TABLE USERS");
    		stmt.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
	/**Deletes row from USERS based on user_id
	 * @param user_id */
	public static void deleteUsersRow(int user_id) {
		try{
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM USERS WHERE USER_ID=" + user_id);
			stmt.close();
			System.out.println("Users Line deleted");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**Deletes row from LOCATIONS based on user_id
	 * @param user_id */
	public static void deleteLocationsRow(int user_id) {
		try{
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM LOCATIONS WHERE USER_ID=" + user_id);
			stmt.close();
			System.out.println("Users Line deleted");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
    /**Inserts rows into users table
     * @param User_name 
     * @param Password */
    public static void insertIntoUserTable(String User_name, String Password) {
    		try {
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("SELECT MAX(USER_ID) FROM USERS");
	            results.next();
	            int id = results.getInt(1) + 1;
	            stmt.execute("INSERT INTO USERS" + " VALUES ("+ id + ",'" + User_name + "','" + Password +"')");
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
    
    
    
    /**Inserts rows into locations table
     * @param City 
     * @param Address 
     * @param arrival_time 
     * @param departure_time 
     * @param date 
     * @param user_id */
    public static void insertIntoLocationsTable(String City, String Address, int arrival_time,int departure_time,String date, int user_id) {
    	try {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO LOCATIONS" + " VALUES ('" + City + "','"+Address+"',"+arrival_time+"," + departure_time +",'"+ date +"',"+user_id+")");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /**Prints the users table*/
    public static void printUsersTable() {
	        try {
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("SELECT * FROM USERS");
	            ResultSetMetaData rsmd = results.getMetaData();
	            int numberCols = rsmd.getColumnCount();
	            
	            System.out.println("\n--------------------------------------------");
	            for (int i=1; i<=numberCols; i++)
	            {
	                //print Column Names
	                System.out.printf("%-18s", rsmd.getColumnLabel(i));  
	            }
	            System.out.println("\n--------------------------------------------");

	            while(results.next()) {
	                int id = results.getInt(1);
	                String Name = results.getString(2);
	                String pass = results.getString(3);
	                System.out.printf("%-18s%-18s%-18s%n", id, Name, pass);
	            }
	            results.close();
	            stmt.close();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
    
    
    /**Prints the locations table*/
    public static void printLocationsTable() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM LOCATIONS");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.printf("%-18s", rsmd.getColumnLabel(i));  
            }

            System.out.println("\n-------------------------------------------------------------------------------------------------");

            while(results.next()){
                String City = results.getString(1);
                String Address = results.getString(2);
                int arrival_time = results.getInt(3);
                int departure_time = results.getInt(4);
                String date = results.getString(5);
                int user_id = results.getInt(6);
                System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",City , Address , arrival_time, departure_time ,date, user_id);
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
	/**
	 * Prints user's locations
	 * @param id
	 */
	public static void printUserLocations(int id) {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM LOCATIONS WHERE USER_ID=" + id);
			ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.printf("%-18s", rsmd.getColumnLabel(i));  
            }

            System.out.println("\n-------------------------------------------------------------------------------------------------");

            while(results.next()){
                String City = results.getString(1);
                String Address = results.getString(2);
                int arrival_time = results.getInt(3);
                int departure_time = results.getInt(4);
                String date = results.getString(5);
                int user_id = results.getInt(6);
                System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",City , Address , arrival_time, departure_time ,date, user_id);
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }





    /**
     * Checks if the given user name exists
     * @param user_name 
     * @return returns true if user name exists, false if not
     */
	public static boolean usernameCheck(String user_name) {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT USER_NAME FROM USERS");
			while(results.next()) {
				String existingName = results.getString("USER_NAME");
				if (existingName.equals(user_name)) {
					return true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}



	/**
	 * Searching for user_id based on user_name
	 *  
	 * @param name 
	 * @return Returns users id or -1 if the user_name does not exist in the database
	 */
	public static int findUsersId(String name) {
		int id = -1;
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT USER_ID, USER_NAME FROM USERS");
			while(results.next()) {
				String existingNames = results.getString("USER_NAME");
				if (name.equals(existingNames)) {
					id = results.getInt("USER_ID");
					return id;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * Searching for user's password based on user_id
	 *
	 * @param user_id 
	 * @return Returns user's password or returns -1 in String format if password not found
	 */
	public static String findUsersPass(int user_id) {
		String pass = "-1";
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT PASSWORD FROM USERS WHERE USER_ID=" + user_id);
			results.next();
			pass = results.getString(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}
	
	
	/**
	 * Searching for user's name based on user_id
	 * 
	 * @param user_id
	 * @return Returns user's name or returns -1 in String format if password not found
	 */
	public static String findUserName(int user_id) {
		String user_name = "-1";
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT USER_NAME FROM USERS WHERE USER_ID=" + user_id);
			results.next();
			user_name = results.getString(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user_name;
	}

	/**
	 * Gets user's ID and finds all his locations in the past 14 days,
	 * then finds all other users who where in the same location at the same time
	 * @param user_id
	 * @return arrayList of all possibly infected users
	 */
	public static ArrayList<Integer> findConnections(int user_id) {
		
		//used to store possibly infected users
		ArrayList<Integer> infected = new ArrayList<Integer>();
		
		try {
		
			//14 days before the method is called
			Date currentDate = new Date(System.currentTimeMillis()-14*24*60*60*1000);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String infectionDate = formatter.format(currentDate);
			
			//user's 14 day locations
			stmt = conn.createStatement();
			ResultSet results;
			results = stmt.executeQuery("SELECT * "
					+ "FROM LOCATIONS "
					+ "WHERE USER_ID="+user_id + " AND DAY>'" + infectionDate + "'");
			
			//data storage
			ArrayList<String> City = new ArrayList<String>();
			ArrayList<String> Address = new ArrayList<String>();
			ArrayList<Integer> arrival_time = new ArrayList<Integer>();
			ArrayList<Integer> departure_time = new ArrayList<Integer>();
			ArrayList<String> date = new ArrayList<String>();
			
			//every location data gets into arraylists
            while(results.next()){
            	City.add(results.getString(1));
                Address.add(results.getString(2));
                arrival_time.add(results.getInt(3));
                departure_time.add(results.getInt(4));
                date.add(results.getString(5));
            }
            
            
            int locations_number = City.size();//number of locations the user visited
            
            //every user that had been in the same locations
            for (int x = 0; x<locations_number; x++) {
            	
            	results = stmt.executeQuery("SELECT USER_ID " //Getting user's ID
                		+ "FROM LOCATIONS "
                		+ "WHERE CITY='"+ City.get(x) +"' "//Exclude different city
                		+ "AND ADDRESS='"+ Address.get(x)+"' "//Exclude different address 
                		+ "AND DAY='" + date.get(x) + "' " //Exclude different date
                		+ "AND ((ARRIVAL_TIME<="+ departure_time.get(x) + " AND ARRIVAL_TIME>=" +arrival_time.get(x) + ")"
                				+ " OR "
                				+ "(DEPARTURE_TIME<=" + departure_time.get(x) +"AND DEPARTURE_TIME>=" + arrival_time.get(x)+ ")) "//Exclude different time
                		+ "AND USER_ID!=" + user_id);//Exclude same user
            	
            	//store data in the arraylist
            	while(results.next()){
                    infected.add(results.getInt(1));
                }
            }
            
            results.close();
            stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return infected;
	}






	


}
