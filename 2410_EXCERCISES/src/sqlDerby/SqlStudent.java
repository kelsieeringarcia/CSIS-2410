package sqlDerby;
/**
 * Contains SQL statements relating to the Student table.
 * @author kelsiegarcia
 *
 */
public class SqlStudent {

	public static final String createTable() {
			return "CREATE TABLE Student (" 
			+ "ID int not null primary key"
			+ " GENERATED ALWAYS AS IDENTITY" 
			+ " (START WITH 1234, INCREMENT BY 1)," 
			+ "FirstName varchar(255),"
			+ "LastName varchar(255)," + "Major varchar(255)," 
			+ "GradYear int)";
	}

	public static final String DropTable () {
		return "DROP TABLE Student";
	}

	public static final String InsertData () {
		return "INSERT INTO Student (FirstName, LastName, Major, GradYear) "
			+ "VALUES ('Joe' , 'Bing', 'CS', 2021)," 
			+ " ('Pam' , 'Ryan', 'EN', 2024),"
			+ " ('Max' , 'Hank', 'CE', 2019)," 
			+ " ('Amy' , 'Blue', 'CS', 2022) ";
	}

	public static final String getAll() {
		return "SELECT ID, FirstName, LastName, Major, GradYear " 
				+ "FROM Student";
	}
	
	public static final String getAllIdAndName() {
		return "SELECT ID, FirstName, LastName " 
				+ "FROM Student";
	}
	
	public static final String getAllCSStudents() {
		return "SELECT * " 
				+ "FROM Student " 
				+ "WHERE Major = 'CS' ";
	}
}
