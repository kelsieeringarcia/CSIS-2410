package sqlDerby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DemoDatabase {

	private static final String dataBaseURL = "jdbc:derby:FirstDataBase;create=true";

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
	
	//... makes an array of queries to be executed
	private static void printQueryResults(String...queries) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();) {
	
			for(String query : queries) {
				ResultSet resultSet = statement.executeQuery(query);
				printResults(resultSet);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ResultSet getResultSet(String query) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();) {
	
				return statement.executeQuery(query);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//add constructor student to a list in order to print out the constructed student data
	private static List<Student> getStudentList() {
		List<Student> students = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();) {
	
				ResultSet resultSet = statement.executeQuery(SqlStudent.getAll());
				//add students to list

				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String firstName = resultSet.getString(2);
					String lastName = resultSet.getString(3);
					String major = resultSet.getString(4);
					int gradYear = resultSet.getInt(5);
					
					students.add(new Student(id, firstName, lastName, major, gradYear));
				}
					
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	/**
	 * executes sql statements
	 * @param sqlStatement
	 */
	private static void execute(String sqlStatement) {
		try (Connection connection = DriverManager.getConnection(dataBaseURL);
				Statement statement = connection.createStatement();) {
			
			statement.execute(sqlStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*printQueryResults(SqlStudentCollege.getAll(), SqlCollege.getAll(), SqlStudent.getAll(), 
				SqlStudentCollege.getStudentNamesAndColleges());*/
		List<Student> studentList = new ArrayList<>();
		
		System.out.println("List of all Students: ");
		for(Student s : studentList) {
			System.out.println(s);
		}
		//System.out.println(studentList);
		
		System.out.println("\ndone.");

	}

}
