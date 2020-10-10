package flights;

/**
 * SQL queries for the Airport table
 *@author Kelsie Garcia and Aiden Van Dyke
 *
 */
public class SqlAirport {

	/**
	 * Drops Airport table.
	 * @return SQL statement
	 */
    public static String dropTable() {
        return "DROP TABLE Airport";
    }

    /**
     * Creates the Airport table.
     * @return SQL statement
     */
    public static String createTable() {
        return
                "CREATE TABLE Airport ("
                + "Id varchar(255) not null primary key, "
                + "Name varchar(255), "
                + "City varchar(255), "
                + "Country varchar(255))";
    }

    /**
     * Removes from Airport table.
     * @return SQL statement
     */
    public static String removeData() {
        return
                "DELETE FROM Airport";
    }

    /**
     * Inserts data into Airport table.
     * @return SQL statement
     */
    public static String insertData() {
        return
                "INSERT INTO Airport (Id, Name, City, Country) "
                + "VALUES ('EGLL', 'London Heathrow Airport', 'London', 'United Kingdom'), "
                + "('EHAM', 'Amsterdam Airport Schiphol', 'Amsterdam', 'Netherlands'), "
                + "('KATL', 'Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States'), "
                + "('KBOS', 'Boston Logan International Airport', 'Boston', 'United States'), "
                + "('KDEN', 'Denver International Airport', 'Denver', 'United States'), "
                + "('KDFW', 'Dallas/Fort Worth International Airport', 'Dallas', 'United States'), "
                + "('KJFK', 'John F. Kennedy International Airport', 'New York', 'United States'), "
                + "('KLAS', 'McCarran International Airport', 'Las Vegas', 'United States'), "
                + "('KLAX', 'Los Angeles International Airport', 'Los Angeles', 'United States'), "
                + "('KMIA', 'Miami International Airport', 'Miami', 'United States'), "
                + "('KORD', 'O\'\'Hare International Airport', 'Chicago', 'United States'), "
                + "('KPDX', 'Portland International', 'Portland', 'United States'), "
                + "('KPHX', 'Phoenix Sky Harbor International Airport', 'Phoenix', 'United States'), "
                + "('KSEA', 'Seattle-Tacoma International Airport', 'Seattle', 'United States'), "
                + "('KSFO', 'San Francisco International Airport', 'San Francisco', 'United States'), "
                + "('KSLC', 'Salt Lake City International', 'Salt Lake', 'United States'), "
                + "('LFPG', 'Paris Charles de Gaulle Airport', 'Paris', 'France'), "
                + "('RJAA', 'Tokyo Narita International Airport', 'Tokyo', 'Japan'), "
                + "('VHHH', 'Hong Kong International Airport', 'Hong Kong', 'Hong Kong'), "
                + "('ZSPD', 'Shanghai Pudong International Airport', 'Shanghai', 'China')";
    }

    /**
     * Selects all from Airport table.
     * @return SQL statement
     */
    public static String getAll() {
        return
                "SELECT * "
                + "FROM Airport";
    }

    /**
     * Takes the AirportCity and turns it to the AirportId
     * @param airportCity
     * @return AirportId
     */
    @SuppressWarnings("preview")
	public static String getId(String airportCity) {
        String airportId = switch (airportCity) {
            case "Amsterdam" -> "EHAM";
            case "Atlanta" -> "KATL";
            case "Boston" -> "KBOS";
            case "Denver" -> "KDEN";
            case "Dallas" -> "KDFW";
            case "New York" -> "KJFK";
            case "Las Vegas" -> "KLAS";
            case "Los Angeles" -> "KLAX";
            case "Miami" -> "KMIA";
            case "Chicago" -> "KORD";
            case "Portland" -> "KPDX";
            case "Phoenix" -> "KPHX";
            case "Seattle" -> "KSEA";
            case "San Francisco" -> "KSFO";
            case "Salt Lake" -> "KSLC";
            case "London" -> "EGLL";
            case "Paris" -> "LFPG";
            case "Tokyo" -> "RJAA";
            case "Hong Kong" -> "VHHH";
            case "Shanghai" -> "ZSPD";
            default -> "";
        };
        return airportId;
    }

}
