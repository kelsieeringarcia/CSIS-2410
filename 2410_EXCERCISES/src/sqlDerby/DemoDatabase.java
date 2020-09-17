package sqlDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoDatabase {

	private static final String dataBaseURL = "jdbc:derby:FirstDataBase;create=true";

	private static final String sqlCreateStudentTable = "CREATE TABLE Student (" + "ID int not null primary key"
			+ " GENERATED ALWAYS AS IDENTITY" + " (START WITH 1234, INCREMENT BY 1)," + "FirstName varchar(255),"
			+ "LastName varchar(255)," + "Major varchar(255)," + "GradYear int)";

	private static final String sqlDropStudentTable = "DROP TABLE Student";

	private static final String sqlInsertStudentData = "INSERT INTO Student (FirstName, LastName, Major, GradYear) "
			+ "VALUES ('Joe' , 'Bing', 'CS', 2021)," + " ('Pam' , 'Ryan', 'EN', 2024),"
			+ " ('Max' , 'Hank', 'CE', 2019)," + " ('Amy' , 'Blue', 'CS', 2022) ";

	private static final String sqlAllStudents = "SELECT ID, FirstName, LastName, Major, GradYear " + "FROM Student";
	
	private static final String sqlAllStudentsIDandName = "SELECT ID, FirstName, LastName " + "FROM Student";
	
	private static final String sqlAllCSStudents = "SELECT * " + "FROM Student " + "WHERE Major = 'CS' ";
	
	private static final String sqlCreateCollegeTable = "CREATE TABLE College (" 
			+ "ID int not null primary key"
			+ " GENERATED ALWAYS AS IDENTITY" 
			+ " (START WITH 7123, INCREMENT BY 1)," 
			+ "Name varchar(255),"
			+ "State varchar(2))";
	
	private static final String sqlInsertCollegeData = "INSERT INTO College (Name, State) " 
			+ "VALUES ('SLCC' , 'UT'), "
			+ "('BYU', 'UT'), "
			+ "('UVU', 'UT'), "
			+ "('YALE', 'CT')";
	
	private static final String sqlAllCollege = "SELECT * " + "FROM College";
	
	private static final String sqlCreateStudentCollegeTable = "CREATE TABLE StudentCollege (" 
			+ "StudentId int,"
			+ "CollegeId int)";
	
	private static final String sqlInsertStudentCollegeData = "INSERT INTO StudentCollege (StudentId, CollegeId) " 
			+ "VALUES (1234, 7124), "
			+ "(1235, 7126), "
			+ "(1236, 7125), "
			+ "(1236, 7125), "
			+ "(1237, 7123)";
	
	private static final String sqlAllStudentCollege = "SELECT * " + "FROM StudentCollege";

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

	private static void printDataSets(ResultSet resultSet, ResultSetMetaData metaData) {
		int columnCount;
		try {
			columnCount = metaData.getColumnCount();
			// create an array that stores the widths of the columns
			int[] columnWidths = new int[columnCount + 1];
			for (int i = 1; i <= columnCount; i++) {
				columnWidths[i] = metaData.getColumnLabel(i).length();
			}
			//Print data records in straight columns
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String formatString = "%-" + columnWidths[i] + "s  ";
					System.out.printf(formatString, resultSet.getObject(i));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("A problem occured printing the data records.");
			e.printStackTrace();
		}

	}

	private static void printHeader(ResultSetMetaData metaData) {
		try {
			int columnCount = metaData.getColumnCount();
			System.out.println("  ");
			for (int i = 1; i <= columnCount; i++) {

				System.out.print(metaData.getColumnLabel(i) + "  ");
			}
			System.out.println();

		} catch (SQLException e) {
			System.out.println("A problem occured printing the header.");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();) {

			
			//statement.execute(sqlCreateStudentCollegeTable);
			//statement.execute(sqlInsertStudentCollegeData);
			ResultSet resultSet = statement.executeQuery(sqlAllStudentCollege);
			printResults(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\ndone.");

	}

}
