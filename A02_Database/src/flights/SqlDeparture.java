package flights;

public class SqlDeparture {

    public static String dropTable() {
        return
                "DROP TABLE Departure";
    }

    public static String createTable() {
        return
                "CREATE TABLE Departure ("
                + "DepartureId int NOT NULL PRIMARY KEY "
                + "  GENERATED ALWAYS AS IDENTITY "
                + "  (START WITH 1000, INCREMENT BY 1), "
                + "AirlineId varchar(255), "
                + "FlightNumber int, "
                + "Destination varchar(255), "
                + "Status int, "
                + "Gate varchar(255), "
                + "Date varchar(255), "
                + "Time varchar(255), "
                + "Duration int, "
                + "FOREIGN KEY(AirlineId) REFERENCES Airline(AirlineId), "
                + "FOREIGN KEY(Destination) REFERENCES Airport(AirportId), "
                + "FOREIGN KEY(Status) REFERENCES Status(StatusId), "
                + "FOREIGN KEY(Gate) REFERENCES Gate(GateId))";
    }

    public static String removeData() {
        return
                "DELETE FROM Departure";
    }

    public static String insertData() {
        return
                "INSERT INTO Departure (AirlineId, FlightNumber, Destination, Status, Gate, Date, Time, Duration) "
                + "VALUES ('AA', 1300, 'KSEA', 0, 'A05', '09-14', '03:00', 30), "
                + "('AA', 0148, 'KLAX', 0, 'C04', '10-12', '18:15', 60), "
                + "('AA', 6711, 'KDFW', 1, 'C02', '09-29', '24:30', 120), "
                + "('AA', 7099, 'KORD', 0, 'A02', '10-11', '05:30', 40), "
                + "('AF', 7028, 'LFPG', 0, 'B03', '10-06', '21:15', 45), "
                + "('AF', 8207, 'EGLL', 0, 'B03', '09-06', '05:00', 500), "
                + "('AS', 0194, 'KSEA', 1, 'A02', '10-30', '15:00', 90), "
                + "('AS', 4493, 'KSLC', 0, 'B04', '10-12', '13:00', 80), "
                + "('AS', 9189, 'KPDX', 2, 'C03', '10-09', '20:30', 75), "
                + "('BA', 1640, 'EGLL', 0, 'C04', '10-21', '16:15', 120), "
                + "('BA', 1759, 'RJAA', 0, 'B02', '09-18', '04:15', 600), "
                + "('DL', 2116, 'KSEA', 0, 'B05', '10-08', '05:30', 200), "
                + "('DL', 4879, 'KATL', 0, 'A05', '10-04', '16:00', 240), "
                + "('DL', 9482, 'KSLC', 1, 'B05', '10-19', '18:45', 30), "
                + "('DL', 9690, 'KPHX', 0, 'A02', '10-09', '16:45', 60), "
                + "('JL', 5790, 'EGLL', 0, 'B05', '09-09', '17:15', 550), "
                + "('JL', 7029, 'KJFK', 2, 'C03', '09-08', '20:15', 340), "
                + "('JL', 7077, 'RJAA', 0, 'A05', '10-17', '17:00', 540), "
                + "('KL', 4720, 'EHAM', 0, 'A01', '09-12', '17:00', 60), "
                + "('KL', 8230, 'VHHH', 0, 'A03', '09-20', '05:30', 240), "
                + "('KL', 9966, 'ZSPD', 2, 'A04', '09-01', '00:00', 210), "
                + "('NH', 3135, 'RJAA', 0, 'A02', '10-10', '03:45', 60), "
                + "('NH', 4299, 'RJTT', 0, 'C05', '10-04', '24:45', 330), "
                + "('UA', 3451, 'KDFW', 3, 'C01', '09-22', '12:15', 340), "
                + "('UA', 5360, 'KBOS', 3, 'C05', '09-12', '12:45', 280), "
                + "('UA', 5440, 'KDEN', 2, 'C01', '10-05', '15:30', 170), "
                + "('WN', 5494, 'KLAX', 0, 'A03', '10-19', '06:15', 45), "
                + "('WN', 5637, 'KSLC', 0, 'C04', '10-03', '14:45', 120), "
                + "('WN', 6513, 'KLAS', 1, 'C02', '09-13', '20:00', 150), "
                + "('WN', 9018, 'KPHX', 0, 'A05', '09-03', '03:45', 160)";
    }

    public static String getAll() {
        return
                "SELECT * "
                + "FROM Departure";
    }

    /**
     * Find all departing flights and sort them by a specified column
     * @param column An enum that matches a column name of the departure table
     * @return A Sql String that returns a sorted table of departures
     */
    public static String getAllSorted(SqlDepartureColumn column) {
        return
                "SELECT * "
                + "FROM Departure "
                + "ORDER BY " + column.getColumn() + ", AirlineId, FlightNumber, Destination, Status";
    }

    /**
     * Find all departing flights and sort them by a specified column
     * Replaces AirportId, AirlineId, and Status Code with descriptive names
     * @param column An enum that matches a column name of the departure table
     * @return A Sql String that returns a sorted table of departures
     */
    public static String getAllSortedWithNames(SqlDepartureColumn column) {
        return
                "SELECT "
                + "Airline.AirlineName, Departure.FlightNumber, "
                + "Status.StatusDescription, Departure.Gate, "
                + "Departure.Date, Departure.Time, Departure.Duration, "
                + "Airport.AirportCity, Airport.AirportName "
                + "FROM Departure "
                + "INNER JOIN Airport ON Departure.Destination=Airport.AirportId "
                + "INNER JOIN Status ON Departure.Status=Status.StatusId "
                + "INNER JOIN Airline ON Departure.AirlineId=Airline.AirlineId "
                + "ORDER BY " + column.getColumn() + ", Departure.AirlineId, Departure.FlightNumber";
    }

    /**
     * Find and return all departing flights
     * that have the specified Airport as a destination
     * @param AirportId A 4 digit ICAO airport identifier
     * @return A Sql string that returns a filtered table of departures
     */
    public static String getAllWithDestination(String AirportId) {
        return
                "SELECT * "
                + "FROM Departure "
                + "WHERE Destination = '" + AirportId + "'";
    }

    /**
     * Find and return all departing flights, then
     * replace airline identifiers with airline names
     * @return A Sql string that returns a table of departures with airline names
     */
    public static String getAllWithAirlineNames() {
        return
                "SELECT Airline.AirlineName, Departure.FlightNumber "
                + "FROM Departure "
                + "INNER JOIN Airline ON Departure.AirlineId=Airline.AirlineId";

    }
}
