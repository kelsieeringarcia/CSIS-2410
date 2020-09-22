package sqlDerby;
/**
 * Contains SQL statements relating to the Student College table.
 * @author kelsiegarcia
 *
 */
public class SqlStudentCollege {
	public static final String CreateTable () {
		return "CREATE TABLE StudentCollege (" 
			+ "StudentId int,"
			+ "CollegeId int)";
	}
	
	public static final String InsertData() { 
		return "INSERT INTO StudentCollege (StudentId, CollegeId) " 
			+ "VALUES (1234, 7124), "
			+ "(1235, 7126), "
			+ "(1236, 7125), "
			+ "(1236, 7125), "
			+ "(1237, 7123)";
	}
	
	public static final String getAll () {
		return "SELECT * " 
				+ "FROM StudentCollege";
	}
	
	public static final String getStudentNamesAndColleges() { 
		return "SELECT s.FirstName, s.LastName, c.Name "
			+ "FROM Student s "
			+ "INNER JOIN StudentCollege sc ON s.ID = sc.StudentID "
			+ "INNER JOIN College c ON sc.CollegeID = c.ID ";
	}
}
