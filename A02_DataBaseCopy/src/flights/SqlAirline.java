package flights;


/**
 * SQL queries with airline table.
 * @author Kelsie Garcia and Aiden Van Dyke
 *
 */
public class SqlAirline {

	/**
	 * Drops Airline table.
	 * @return SQL statement
	 */
    public static String dropTable() {
        return "DROP TABLE Airline";
    }

    /**
     * Creates the Airline table.
     * @return SQL statement
     */
    public static String createTable() {
        return
                "CREATE TABLE Airline ("
                + "Id varchar(255) not null primary key, "
                + "Name varchar(255))";
    }

    /**
     * Removes data from Airline table.
     * @return SQL statement
     */
    public static String removeData() {
        return
                "DELETE FROM Airline";
    }

    /**
     * Inserts data into Airline table
     * @return SQL statement
     */
    public static String insertData() {
        return
                "INSERT INTO Airline (Id, Name) "
                + "VALUES ('AA', 'American'), "
                + "('AF', 'Air France'), "
                + "('AS', 'Alaska'), "
                + "('BA', 'British'), "
                + "('DL', 'Delta'), "
                + "('JL', 'Japan'), "
                + "('KL', 'Royal Dutch'), "
                + "('NH', 'All Nippon'), "
                + "('UA', 'United'), "
                + "('WN', 'Southwest')";
    }

    /**
     * Selects all data from Airline table
     * @return SQL statement
     */
    public static String getAll() {
        return
                "SELECT * "
                + "FROM Airline";
    }

    /**
     * Takes the AirlineName and returns the AirlineId
     * @param airlineName
     * @return AirlineId
     */
    @SuppressWarnings("preview")
	public static String getId(String airlineName) {
        String id = switch (airlineName) {
            case "American" -> "AA";
            case "Air France" -> "AF";
            case "Alaska" -> "AS";
            case "British" -> "BA";
            case "Delta" -> "DL";
            case "Japan" -> "JL";
            case "Royal Dutch" -> "KL";
            case "All Nippon" -> "NH";
            case "United" -> "UA";
            case "Southwest" -> "WN";
            default -> "";
        };
        return id;
    }
}
