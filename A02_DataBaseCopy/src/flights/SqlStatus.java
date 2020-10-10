package flights;

/**
 * SQL for the Status table.
 * @author Kelsie Garcia and Aiden Van Dyke
 *
 */
public class SqlStatus {

	/**
	 * Drops the status table
	 * @return SQL statement
	 */
    public static String dropTable() {
        return "DROP TABLE Status";
    }

    /**
     * Creates the status table
     * @return SQL statement
     */
    public static String createTable() {
        return
                "CREATE TABLE Status ("
                + "Id int not null primary key, "
                + "Description varchar(255))";
    }

    /**
     * Removes all from status class
     * @return SQL statement
     */
    public static String removeData() {
        return
                "DELETE FROM Status";
    }

    /**
     * Inserts data into the status table
     * @return SQL statement
     */
    public static String insertData() {
        return
                "INSERT INTO Status(Id, Description) "
                + "VALUES (0, 'On Time'), "
                + "(1, 'Now Boarding'), "
                + "(2, 'Delayed'), "
                + "(3, 'Canceled')";
    }

    /**
     * Selects all from status table
     * @return SQL statement
     */
    public static String getAll() {
        return
                "SELECT * "
                + "FROM Status";
    }

    /**
     * Takes the status description string and returns the StatusId
     * @param status
     * @return status Id
     */
    public static int getId(String status) {
        int id = 0;
        if (status.equals("Now Boarding"))
            id = 1;
        if (status.equals("Delayed"))
            id = 2;
        if (status.equals("Canceled"))
            id = 3;
        return id;
    }
}
