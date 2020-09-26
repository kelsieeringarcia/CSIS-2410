package flights;

public enum SqlDepartureColumn {

    ID("Departure.DepartureId"),
    AIRLINE("Departure.AirlineId"),
    FLIGHTNUMBER("Departure.FlightNumber"),
    DESTINATION("Departure.Destination"),
    STATUS("Departure.Status"),
    GATE("Departure.Gate"),
    DATE("Departure.Date"),
    TIME("Departure.Time"),
    DURATION("Departure.Duration");

    private final String column;

    SqlDepartureColumn(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }

}
