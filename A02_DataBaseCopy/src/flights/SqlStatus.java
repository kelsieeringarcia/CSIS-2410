package flights;

public class SqlStatus {

    public static String dropTable() {
        return "DROP TABLE Status";
    }

    public static String createTable() {
        return
                "CREATE TABLE Status ("
                + "Id int not null primary key, "
                + "Description varchar(255))";
    }

    public static String removeData() {
        return
                "DELETE FROM Status";
    }

    public static String insertData() {
        return
                "INSERT INTO Status(Id, Description) "
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
