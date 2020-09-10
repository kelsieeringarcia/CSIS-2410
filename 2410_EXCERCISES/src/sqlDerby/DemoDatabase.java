package sqlDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoDatabase {
	
	private static final String dataBaseURL = 
			"jdbc:derby:FirstDataBase;create=true";

	private static final String sqlCreateStudentTable = "CREATE TABLE Student (" 
			+ "ID int," 
			+ "FirstName varchar(255)," 
			+ "LastName varchar(255)," 
			+ "Major varchar(255)," 
			+ "GradYear int)";
	private static final String sqlInsertStudentData = 
			"INSERT INTO Student (ID, FirstName, LastName, Major, GradYear) " 
			+ "VALUES (1234, 'Joe' , 'Bing', 'CS', 2021),"
			+ " (1235, 'Pam' , 'Ryan', 'EN', 2024),"
			+ " (1236, 'Max' , 'Hank', 'CE', 2019),"
			+ " (1237, 'Amy' , 'Blue', 'CS', 2022) ";
	
	private static final String sqlAllStudents = "SELECT ID, FirstName, LastName, Major, GradYear "
			+ "FROM Student";
	
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();){
			//statement.execute(sqlInsertStudentData); 
			ResultSet resultSet = statement.executeQuery(sqlAllStudents);
			
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		System.out.println("done.");

	}

}
