package gr.aueb.dmst.StopSpread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author AirlineDog Database handling class
 */
public class Database {

	/** Database URL */
	private static final String dbURL = "jdbc:derby:derbyDB";
	/** A connection with the database */
	private static Connection conn = null;
	/**
	 * The object used for executing a static SQL statement and returning the
	 * results it produces
	 */
	private static Statement stmt = null;

	/** Initiates connection with the database */
	public void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			// System.out.println("Database connection created");
		} catch (Exception e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/** Terminates connection with the database */
	public void shutdownConnection() {
		try {
			// the shutdown=true attribute shuts down Derby
			DriverManager.getConnection("jdbc:derby:;shutdown=true");

			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			if (((e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState())))) {
				// we got the expected exception
				// System.out.println("Derby shut down normally");
			} else {
				// if the error code or SQLState is different, we have
				// an unexpected exception (shutdown failed)
				System.err.println("Derby did not shut down normally");
				e.printStackTrace();
			}
			// System.out.println("database shutdown");
		} // end of try-catch
	}// end of method

	/**
	 * Creates Table of users with columns
	 * <P>
	 * USER_ID, USER_NAME, PASSWORD, POSSIBLY_INFECTED
	 */
	public void createUsersTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("CREATE TABLE USERS(" + "USER_ID INT NOT NULL," + "USER_NAME VARCHAR(255),"
					+ "PASSWORD VARCHAR(30)," + "POSSIBLY_INFECTED BOOLEAN," + "PRIMARY KEY (USER_ID) )");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Creates Table of user's Locations with columns :
	 * <P>
	 * CITY, ADDRESS, ARRIVAL_TIME, DEPARTURE_TIME, USER_ID
	 */
	public void createLocationsTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("CREATE TABLE LOCATIONS(" + "CITY VARCHAR(255)," + "ADDRESS VARCHAR(255),"
					+ "ARRIVAL_TIME INT," + "DEPARTURE_TIME INT," + "DAY DATE," + "USER_ID INT,"
					+ "FOREIGN KEY (USER_ID) REFERENCES USERS ON DELETE CASCADE)");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/** Creates Table of user's Evaluation with columns :
	 * <P>
	 * VERY_BAD, BAD, METRIA , GOOD, VERY_GOOD
	 */
	public void createEvaluationTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("CREATE TABLE EVALUATION ("
					+ "VERY_BAD INT,"
					+ "BAD INT,"
					+ "METRIA INT,"
					+ "GOOD INT,"
					+ "VERY_GOOD INT"
					+")");
			stmt.execute("INSERT INTO EVALUATION "
					+ "VALUES (0,0,0,0,0)");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}


	public void createEvaluationComents() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("CREATE TABLE EVALUATIONCOMMS ("
					+ "COMMS VARCHAR(255)"
					+")");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	public void createCountToVoteOnce() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("CREATE TABLE COUNTTOVOTE ("
					+ "ID_VOTED INT"
					+")");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method


	/** Creates Table of users Stories with columns :
	 * <P>
	 * STORY_ID, STORY_TITLE, STORY
	 */
	public void createStoriesTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute(
					"CREATE TABLE STORIES("
						+ "STORY_ID INT, "
						+ "STORY_TITLE VARCHAR(255),"
						+ "STORY LONG VARCHAR)");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/** Deletes the users and locations tables */
	public void deleteTables() {
		try {
			stmt = conn.createStatement();// create a Statement
			// stmt.execute("DROP TABLE LOCATIONS ");
			// stmt.execute("DROP TABLE USERS");
			//stmt.execute("DROP TABLE STORIES");
			//stmt.execute("DROP TABLE EVALUATION");
			//stmt.execute("DROP TABLE EVALUATIONCOMMS");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Deletes row from USERS based on user_id and consequently LOCATIONS rows with
	 * the same foreign key are deleted
	 *
	 * @param user_id
	 */
	public void deleteUsersRow(int user_id) {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("DELETE FROM USERS WHERE USER_ID=" + user_id);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Deletes row from LOCATIONS based on user_id
	 *
	 * @param user_id
	 */
	public void deleteLocationsRow(int user_id) {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("DELETE FROM LOCATIONS WHERE USER_ID=" + user_id);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Inserts rows into users table
	 * <P>
	 * POSSIBLY_INFECTED column gets pre-set as FALSE
	 *
	 * @param User_name
	 * @param Password
	 */
	public void insertIntoUserTable(String User_name, String Password) {
		try {
			stmt = conn.createStatement();// create a Statement

			// find the next available user id
			ResultSet results; // A table of data representing a database result
			results = stmt.executeQuery("SELECT MAX(USER_ID) FROM USERS");
			results.next();// set the cursor to the next data
			int id = results.getInt(1) + 1; // get the data and add 1 to be the user id

			stmt.execute("INSERT INTO USERS" + " VALUES (" + id + ",'" + User_name + "','" + Password + "', FALSE)");

			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	public void instertEvalComments(String comment) {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("INSERT INTO EVALUATIONCOMMS"
						+ " VALUES ('" + comment + "')" );
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method


	public void insterIntoIdsWhoVoted(int ids) {
		try {
			stmt = conn.createStatement();// create a Statement

			stmt.execute("INSERT INTO COUNTTOVOTE" + " VALUES (" + ids + ")" );

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Inserts rows into locations table
	 *
	 * @param City
	 * @param Address
	 * @param arrival_time
	 * @param departure_time
	 * @param date
	 * @param user_id
	 */
	public void insertIntoLocationsTable(String City, String Address, int arrival_time, int departure_time, String date,
			int user_id) {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("INSERT INTO LOCATIONS" + " VALUES ('" + City + "','" + Address + "'," + arrival_time + ","
					+ departure_time + ",'" + date + "'," + user_id + ")");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Inserts rows into EvaluationTable
	 * @param choice
	 */
	public void insertIntoEvaluationTable(int choice) {
		try {
			stmt = conn.createStatement();// create a Statement
			if(choice == 1) {
				stmt.execute("UPDATE EVALUATION "
						+"SET VERY_BAD = VERY_BAD + 1");
			} else if(choice == 2) {
				stmt.execute("UPDATE EVALUATION "
						+"SET BAD = BAD + 1");
			} else if(choice ==3) {
				stmt.execute("UPDATE EVALUATION "
						+"SET METRIA = METRIA + 1");
			} else if(choice ==4) {
				stmt.execute("UPDATE EVALUATION "
						+"SET GOOD = GOOD + 1");
			} else if(choice == 5) {
				stmt.execute("UPDATE EVALUATION "
						+"SET VERY_GOOD = VERY_GOOD + 1");
			}


		} catch(SQLException e) {
			e.printStackTrace();
		} //ending of catch

	}

	/**
	 * Inserts rows into Stories table
	 * @param storyTitle
	 * @param storyBody
	 *
	 */
	public void insertIntoStoriesTable(String storyTitle, String storyBody) {
		try {
			stmt = conn.createStatement();// create a Statement

			// find the next available user id
			ResultSet results; // A table of data representing a database result
			results = stmt.executeQuery("SELECT MAX(STORY_ID) FROM STORIES");
			results.next();// set the cursor to the next data
			int id = results.getInt(1) + 1; // get the data and add 1 to be the user id

			stmt.execute("INSERT INTO STORIES" + " VALUES (" + id + ",'" + storyTitle + "','" + storyBody + "')");

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/** Prints the users table */
	public void printUsersTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT * FROM USERS");
			ResultSetMetaData rsmd = results.getMetaData(); // An object that can be used to get information about the
															// types and properties of the columns in a ResultSet object
			int numberCols = rsmd.getColumnCount();// get number of columns

			// output format
			System.out.println("\n-----------------------------------------------------------------------");
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.printf("%-18s", rsmd.getColumnLabel(i));
			} // end of for
			System.out.println("\n-----------------------------------------------------------------------");

			while (results.next()) {
				int id = results.getInt(1);
				String Name = results.getString(2);
				String pass = results.getString(3);
				boolean poss_inf = results.getBoolean(4);
				System.out.printf("%-18s%-18s%-18s%-18s%n", id, Name, pass, poss_inf);
			} // end of while
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/** Prints the locations table */
	public void printLocationsTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT * FROM LOCATIONS");
			ResultSetMetaData rsmd = results.getMetaData(); // An object that can be used to get information about the
															// types and properties of the columns in a ResultSet object
			int numberCols = rsmd.getColumnCount();// get number of columns

			// output format
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------");
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.printf("%-18s", rsmd.getColumnLabel(i));
			} // end of for

			System.out.println(
					"\n-------------------------------------------------------------------------------------------------");

			while (results.next()) {
				String City = results.getString(1);
				String Address = results.getString(2);
				int arrival_time = results.getInt(3);
				int departure_time = results.getInt(4);
				String date = results.getString(5);
				int user_id = results.getInt(6);
				System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n", City, Address, arrival_time, departure_time, date,
						user_id);
			} // end of while
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Prints the locations table
	 */
	public void printStoriesTable() {
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT * FROM STORIES");
			ResultSetMetaData rsmd = results.getMetaData(); // An object that can be used to get information about the
															// types and properties of the columns in a ResultSet object
			int numberCols = rsmd.getColumnCount();// get number of columns

			// output format
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------");
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.printf("%-18s", rsmd.getColumnLabel(i));
			} // end of for

			System.out.println(
					"\n-------------------------------------------------------------------------------------------------");

			while (results.next()) {
				int id = results.getInt(1);
				String storyTitle = results.getString(2);
				String storyBody = results.getString(3);

				System.out.printf("%-18s%-18s%-18s\n", id, storyTitle, storyBody);
			} // end of while
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * Passes data for server usage
	 *
	 * @param id
	 * @return ResultSet for user_id matching rows
	 */
	public ResultSet userLocationsResult(int id) {
		ResultSet results = null;// A table of data representing a database result
		try {
			stmt = conn.createStatement();// create a Statement
			results = stmt.executeQuery("SELECT * FROM LOCATIONS WHERE USER_ID=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return results;
	}// end of method

	/**
	 * Checks if the given user name exists
	 *
	 * @param user_name
	 * @return true if user name exists
	 *         <P>
	 *         false if not
	 */
	public boolean usernameCheck(String user_name) {
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT USER_NAME FROM USERS");

			while (results.next()) {
				String existingName = results.getString("USER_NAME");
				if (existingName.equals(user_name)) {
					return true;
				} // end of if
			} // end of while
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return false;
	}// end of method

	/**
	 * Searching for user_id based on user_name
	 *
	 * @param name
	 * @return users id
	 *         <P>
	 *         or -1 if the user_name does not exist in the database
	 */
	public int findUsersId(String name) {
		int id = -1; // initialize id
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results; // A table of data representing a database result
			results = stmt.executeQuery("SELECT USER_ID, USER_NAME FROM USERS");
			while (results.next()) {
				String existingNames = results.getString("USER_NAME");
				if (name.equals(existingNames)) {
					id = results.getInt("USER_ID");
					return id;
				} // end of if
			} // end of while
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return id;
	}// end of method

	/**
	 * Searching for user's password based on user_id
	 *
	 * @param user_id
	 * @return user's password
	 *         <P>
	 *         or -1 in String format if password not found
	 */
	public String findUsersPass(int user_id) {
		String pass = "-1";// initialize password
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT PASSWORD FROM USERS WHERE USER_ID=" + user_id);
			results.next();
			pass = results.getString(1);

			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return pass;
	}// end of method

	/**
	 * Searching for user's name based on user_id
	 *
	 * @param user_id
	 * @return user's name
	 *         <P>
	 *         or -1 in String format if password not found
	 */
	public String findUserName(int user_id) {

		String user_name = "-1";// Initialize user_name
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT USER_NAME FROM USERS WHERE USER_ID=" + user_id);
			results.next();
			user_name = results.getString(1);

			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return user_name;
	}// end of method

	public int findUserIdForVote(int user_id) {

		int userid = -1;// Initialize userid
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery("SELECT ID_VOTED FROM COUNTTOVOTE WHERE ID_VOTED =" + user_id);
			if(results.next()) {
				userid = results.getInt(1);
			}
			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return userid;
	}// end of method

	/**
	 * Gets user's ID and finds all his locations in the past 14 days, then finds
	 * all other users who where in the same location at the same time and updates
	 * USERS table column POSSIBLY_INFECTED
	 *
	 * @param user_id
	 */
	public void findConnections(int user_id) {
		try {

			// 14 days before the method is called
			Date currentDate = new Date(System.currentTimeMillis() - 14 * 24 * 60 * 60 * 1000);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String infectionDate = formatter.format(currentDate);

			// user's 14 day locations
			stmt = conn.createStatement();// create a Statement
			ResultSet results;// A table of data representing a database result
			results = stmt.executeQuery(
					"SELECT * " + "FROM LOCATIONS " + "WHERE USER_ID=" + user_id + " AND DAY>'" + infectionDate + "'");

			// data storage
			ArrayList<String> City = new ArrayList<String>();
			ArrayList<String> Address = new ArrayList<String>();
			ArrayList<Integer> arrival_time = new ArrayList<Integer>();
			ArrayList<Integer> departure_time = new ArrayList<Integer>();
			ArrayList<String> date = new ArrayList<String>();

			// every location data gets into the above arraylists
			while (results.next()) {
				City.add(results.getString(1));
				Address.add(results.getString(2));
				arrival_time.add(results.getInt(3));
				departure_time.add(results.getInt(4));
				date.add(results.getString(5));
			} // end of while

			// every user that had been in the same locations
			for (int x = 0; x < City.size(); x++) {

				results = stmt.executeQuery("SELECT DISTINCT USER_ID " // Getting unique user's ID
						+ "FROM LOCATIONS " + "WHERE CITY='" + City.get(x) + "' "// Same City
						+ "AND ADDRESS='" + Address.get(x) + "' "// Same address
						+ "AND DAY='" + date.get(x) + "' " // Same date
						// Same time
						+ "AND (((ARRIVAL_TIME<=" + departure_time.get(x) + " AND ARRIVAL_TIME>=" + arrival_time.get(x)
						+ ") OR (" + "DEPARTURE_TIME<=" + departure_time.get(x) + "AND DEPARTURE_TIME>="
						+ arrival_time.get(x) + "))" + " OR " + "(ARRIVAL_TIME<" + arrival_time.get(x)
						+ "AND DEPARTURE_TIME>" + departure_time.get(x) + ")) " + "AND USER_ID!=" + user_id);// Exclude
																												// same
																												// user

			} // end of for

			Statement stmt2 = conn.createStatement();// can't update table in the same Statement

			while (results.next()) {
				stmt2.execute(
						"UPDATE USERS " + "SET POSSIBLY_INFECTED = TRUE " + "WHERE USER_ID = " + results.getInt(1));
			} // end of while

			results.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch

	}// end of method

	/**
	 * Checks if user has been connected with another infected user
	 *
	 * @param user_id
	 * @return true if user is possibly infected
	 *         <P>
	 *         false if no connections with infected users
	 */
	public boolean checkInfected(int user_id) {

		boolean check = false; // initialize check

		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet result;// A table of data representing a database result
			result = stmt.executeQuery("SELECT POSSIBLY_INFECTED " + "FROM USERS " + "WHERE USER_ID = " + user_id);
			result.next();// set the cursor to the next data
			check = result.getBoolean(1);// get the data from table
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return check;
	}// end of method

	/**
	 * Restores column POSSIBLY_INFECTED to false when user logs in and see the
	 * infected message
	 *
	 * @param user_id
	 */
	public void restoreInfected(int user_id) {
		try {
			stmt = conn.createStatement();// create a Statement
			stmt.execute("UPDATE USERS " + "SET POSSIBLY_INFECTED = FALSE " + "WHERE USER_ID = " + user_id);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
	}// end of method

	/**
	 * @return ResultSet from a random Story*/
	public ResultSet getRandomStory() {
		ResultSet result = null;// A table of data representing a database result
		Random rand = new Random();
		int maxID = 0;
		try {
			stmt = conn.createStatement();// create a Statement
			result = stmt.executeQuery("SELECT MAX(STORY_ID) " + "FROM STORIES ");
			result.next();
			maxID = result.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch

		int randomID = rand.nextInt(maxID) + 1;

		try {
			stmt = conn.createStatement();// create a Statement
			result = stmt.executeQuery("SELECT * " + "FROM STORIES " + "WHERE STORY_ID = " + randomID);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return result;
	}

	/**
	 * @return Number of votes for every choice
	 */
	public int[] getEvaluations() {
		int[] X = new int[5];
		try {
			stmt = conn.createStatement();// create a Statement
			ResultSet result;
			result = stmt.executeQuery("SELECT * FROM EVALUATION");

			result.next();
				X[0] = result.getInt(1);
				X[1] = result.getInt(2);
				X[2] = result.getInt(3);
				X[3] = result.getInt(4);
				X[4] = result.getInt(5);

			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of try-catch
		return X;
	}

}// end of class
