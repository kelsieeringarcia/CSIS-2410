package flights;

public class SqlAirport {

    public static String dropTable() {
        return "DROP TABLE Airport";
    }

    public static String createTable() {
        return
                "CREATE TABLE Airport ("
                + "AirportId varchar(255) not null primary key, "
                + "AirportName varchar(255), "
                + "AirportCity varchar(255), "
                + "AirportCountry varchar(255))";
    }

    public static String removeData() {
        return
                "DELETE FROM Airport";
    }

    public static String insertData() {
        return
                "INSERT INTO Airport (AirportId, AirportName, AirportCity, AirportCountry) "
                + "VALUES ('EGLL', 'London Heathrow Airport', 'London', 'United Kingdom'), "
                + "('EHAM', 'Amsterdam Airport Schiphol', 'Amsterdam', 'Netherlands'), "
                + "('KATL', 'Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States'), "
                + "('KBOS', 'Boston Logan International Airport', 'Boston', 'United States'), "
                + "('KDEN', 'Denver International Airport', 'Denver', 'United States'), "
                + "('KDFW', 'Dallas/Fort Worth International Airport', 'Dallas', 'United States'), "
                + "('KJFK', 'John F. Kennedy International Airport', 'NYC', 'United States'), "
                + "('KLAS', 'McCarran International Airport', 'Las Vegas', 'United States'), "
                + "('KLAX', 'Los Angeles International Airport', 'Los Angeles', 'United States'), "
                + "('KMIA', 'Miami International Airport', 'Miami', 'United States'), "
                + "('KORD', 'O\'\'Hare International Airport', 'Chicago', 'United States'), "
                + "('KPDX', 'Portland International', 'Portland', 'United States'), "
                + "('KPHX', 'Phoenix Sky Harbor International Airport', 'Phoenix', 'United States'), "
                + "('KSEA', 'Seattle-Tacoma International Airport', 'Seattle', 'United States'), "
                + "('KSFO', 'San Francisco International Airport', 'San Francisco', 'United States'), "
                + "('KSLC', 'Salt Lake City International', 'SLC', 'United States'), "
                + "('LFPG', 'Paris Charles de Gaulle Airport', 'Paris', 'France'), "
                + "('RJAA', 'Tokyo Narita International Airport', 'Tokyo', 'Japan'), "
                + "('RJTT', 'Tokyo Haneda Airport', 'Tokyo', 'Japan'), "
                + "('VHHH', 'Hong Kong International Airport', 'Hong Kong', 'Hong Kong'), "
                + "('ZSPD', 'Shanghai Pudong International Airport', 'Shanghai', 'China')";
    }

    public static String getAll() {
        return
                "SELECT * "
                        + "FROM Airport";
    }
}
