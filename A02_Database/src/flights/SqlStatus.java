package flights;

public class SqlStatus {

    public static String dropTable() {
        return "DROP TABLE Status";
    }

    public static String createTable() {
        return
                "CREATE TABLE Status ("
                + "StatusId int not null primary key, "
                + "StatusDescription varchar(255))";
    }

    public static String removeData() {
        return
                "DELETE FROM Status";
    }

    public static String insertData() {
        return
                "INSERT INTO Status(StatusId, StatusDescription) "
                + "VALUES (0, 'On Time'), "
                + "(1, 'Now Boarding'), "
                + "(2, 'Delayed'), "
                + "(3, 'Canceled')";
    }

    public static String getAll() {
        return
                "SELECT * "
                        + "FROM Status";
    }
}
