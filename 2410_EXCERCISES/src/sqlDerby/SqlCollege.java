package sqlDerby;
/**
 * Contains SQL statements relating to the College table.
 * @author kelsiegarcia
 *
 */
public class SqlCollege {
	public static final String CreateTable() {
		return "CREATE TABLE College (" 
			+ "ID int not null primary key"
			+ " GENERATED ALWAYS AS IDENTITY" 
			+ " (START WITH 7123, INCREMENT BY 1)," 
			+ "Name varchar(255),"
			+ "State varchar(2))";
	}
	
	public static final String InsertData() {
		return"INSERT INTO College (Name, State) " 
			+ "VALUES ('SLCC' , 'UT'), "
			+ "('BYU', 'UT'), "
			+ "('UVU', 'UT'), "
			+ "('YALE', 'CT')";
	}
	
	public static final String getAll() {
		return "SELECT * " 
				+ "FROM College";
	}
}
