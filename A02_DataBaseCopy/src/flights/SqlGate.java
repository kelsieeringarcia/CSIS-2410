package flights;

/**
 * SQL for the Gate table.
 * @author Kelsie Garcia and Aiden Van Dyke
 *
 */
public class SqlGate {

	/**
	 * Drops the gate table.
	 * @return SQL statement
	 */
    public static String dropTable() {
        return "DROP TABLE Gate";
    }

    /**
     * Creates gate table.
     * @return SQL statement
     */
    public static String createTable() {
        return
                "CREATE TABLE Gate ("
                + "Id varchar(255) not null primary key)";
    }

    /**
     * Deleting from gate table.
     * @return SQL statement
     */
    public static String removeData() {
        return
                "DELETE FROM Gate";
    }

    /**
     * Inserts data into gate table.
     * @return SQL statement
     */
    public static String insertData() {
        return
                "INSERT INTO Gate(Id) "
                + "VALUES ('A01'), "
                + "('A02'), "
                + "('A03'), "
                + "('A04'), "
                + "('A05'), "
                + "('B01'), "
                + "('B02'), "
                + "('B03'), "
                + "('B04'), "
                + "('B05'), "
                + "('C01'), "
                + "('C02'), "
                + "('C03'), "
                + "('C04'), "
                + "('C05')";
    }

    /**
     * Selects all from gate table
     * @return SQL statement
     */
    public static String getAll() {
        return
                "SELECT * "
                + "FROM Gate";
    }
}
