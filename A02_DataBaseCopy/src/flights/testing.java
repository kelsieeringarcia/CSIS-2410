package flights;

import org.apache.derby.iapi.services.io.DerbyIOException;

import java.sql.*;

public class testing {
    private static final String databaseURL =
            "jdbc:derby:FlightsDB;create=true";

    /**
     * Application entry point. Creates and populates a SQL Table,
     * Then prints the table.
     *
     * @param args Application arguments
     */
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(databaseURL);
                Statement statement = connection.createStatement()) {

            // Reset database for testing with initial data
            //resetTables();

            // Print Table
            //ResultSet resultSet = statement.executeQuery(SqlDeparture.getAll());
        	//'AA', 1300, 'KSEA', 0, 'A05', 'Sep 14', '03:00', 30
            ResultSet resultSet = statement.executeQuery(SqlFlight.updateFlight("AA", 1300, "KSEA", 1, "A05"
            		, "Sept 14", "03:00", 30));
            //ResultSet resultSet = statement.executeQuery(SqlDeparture.getAllWithAirlineNames());
            //ResultSet resultSet = statement.executeQuery(SqlDeparture.getAllWithDestination("EGLL"));
            printResults(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints header and data of a given ResultSet table
     * @param resultSet A SQL ResultSet
     */
    public static void printResults(ResultSet resultSet) {
        printHeader(resultSet);
        printDataSets(resultSet);
    }

    /**
     * Prints SQL Table Header
     *
     * @param resultSet a SQL Query ResultSet
     */
    public static void printHeader(ResultSet resultSet)  {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " ");
            }
            System.out.println();
        }
        catch (SQLException e) {
            System.err.println("A Problem occurred printing the header");
            e.printStackTrace();
        }
    }

    /**
     * Prints SQL Table Contents
     *
     * @param resultSet a SQL Query ResultSet
     */
    public static void printDataSets(ResultSet resultSet) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create an array that stores the width of the columns
            int[] columnWidths = new int[columnCount + 1];
            for (int i = 1; i <= columnCount; i++) {
                columnWidths[i] = metaData.getColumnLabel(i).length();
            }

            // Print data from table in formatted columns
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String formatString = "%-" + columnWidths[i] + "s ";
                    System.out.printf(formatString, resultSet.getObject(i));
                }
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.err.println("A problem occurred printing the data");
            e.printStackTrace();
        }
    }



}
