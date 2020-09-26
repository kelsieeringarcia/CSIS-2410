package flights;

public class SqlAirline {

    public static String dropTable() {
        return "DROP TABLE Airline";
    }

    public static String createTable() {
        return
                "CREATE TABLE Airline ("
                + "AirlineId varchar(255) not null primary key, "
                + "AirlineName varchar(255))";
    }

    public static String removeData() {
        return
                "DELETE FROM Airline";
    }

    public static String insertData() {
        return
                "INSERT INTO Airline (AirlineId, AirlineName) "
                + "VALUES ('AA', 'American'), "
                + "('AF', 'Air France'), "
                + "('AS', 'Alaska'), "
                + "('BA', 'British'), "
                + "('DL', 'Delta'), "
                + "('JL', 'JAL'), "
                + "('KL', 'KLM'), "
                + "('NH', 'ANA'), "
                + "('UA', 'United'), "
                + "('WN', 'Southwest')";
    }

    public static String getAll() {
        return
                "SELECT * "
                + "FROM Airline";
    }
}
