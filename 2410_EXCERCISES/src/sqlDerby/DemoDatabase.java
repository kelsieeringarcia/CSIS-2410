package sqlDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	
	private static void printResults(ResultSet resultSet) {
		
			try {
				ResultSetMetaData metaData = resultSet.getMetaData();
				
				printHeader(metaData);
				printDataSets(resultSet, metaData);
			} catch (SQLException e) {
				System.out.println("A problem occures accessing the metaData");
				e.printStackTrace();
			}
	}

	private static void printDataSets(ResultSet resultSet, ResultSetMetaData metaData) throws SQLException {
		int columnCount = metaData.getColumnCount();
		//create an array that stores the widths of the columns
		int[] columnWidths = new int [columnCount + 1];
		for(int i = 1; i <= columnCount; i++) {
			columnWidths[i] = metaData.getColumnLabel(i).length();
		}
		
		while(resultSet.next()) {
			for(int i = 1; i <= columnCount; i++) {
				String formatString = "%-" + columnWidths[i] + "s  ";
				System.out.printf(formatString, resultSet.getObject(i));
			}
			System.out.println();
		}
	}
	
	private static void printHeader(ResultSetMetaData metaData) {
		try {
			int columnCount = metaData.getColumnCount();
			System.out.println("  ");
			for(int i = 1; i <= columnCount; i++) {
					
					System.out.print(metaData.getColumnLabel(i) + "  ");
				}
				System.out.println();
			
		} catch (SQLException e) {
			System.out.println("A problem occures accessing the metaData");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();){
			//statement.execute(sqlInsertStudentData); 
			ResultSet resultSet = statement.executeQuery(sqlAllStudents);
			printResults(resultSet);
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		System.out.println("done.");

	}

}
