package flights;
/**
 * Constructs the selected Row and other methods to help query data
 * from selected rows.
 * @author kelsiegarcia
 *
 */
public class Row {
	private String col1; 
	private String col2; 
	private String col3; 
	private String col4; 
	private String col5; 
	private String col6; 
	private String col7; 
	private String col8;
	
	/**
	 * This constructs a row so we can manipulate the selected data.
	 * @param col1 AirlineName
	 * @param col2 FlightNumber
	 * @param col3 Destination
	 * @param col4 Status Description
	 * @param col5 Gate
	 * @param col6 Date
	 * @param col7 Time
	 * @param col8 Duration
	 */
	public Row(String col1, String col2, String col3, String col4, String col5, String col6, String col7, String col8) {
		super();
		
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.col4 = col4;
		this.col5 = col5;
		this.col6 = col6;
		this.col7 = col7;
		this.col8 = col8;
	}
	
	/**
	 * Changes the Airline name to Id to fit in query
	 * @return AirlineId
	 */
	public String airlineToId() {
		String id = "";
		switch(col1) {
			case "American":
				id = "AA";
				break;
			case "Air France":
				id = "AF";
				break;
			case "Alaska":
				id = "AS";
				break;
			case "British":
				id = "BA";
				break;
			case "Delta":
				id = "DL";
				break;
			case "Japan":
				id = "Jl";
				break;
			case "Royal Dutch":
				id = "KL";
				break;
			case "All Nippon":
				id = "NH";
				break;
			case "United":
				id = "UA";
				break;
			case "Southwest":
				id = "WN";
				break;
				
		}
		return id;
	}
	/**
	 * Changes the Airline name to Id to fit in query
	 * @param Object of the selected item.
	 * @return AirlineId
	 */
	public String airlineToId(Object object) {
		String id = "";
		switch(col1) {
			case "American":
				id = "AA";
				break;
			case "Air France":
				id = "AF";
				break;
			case "Alaska":
				id = "AS";
				break;
			case "British":
				id = "BA";
				break;
			case "Delta":
				id = "DL";
				break;
			case "Japan":
				id = "Jl";
				break;
			case "Royal Dutch":
				id = "KL";
				break;
			case "All Nippon":
				id = "NH";
				break;
			case "United":
				id = "UA";
				break;
			case "Southwest":
				id = "WN";
				break;
				
		}
		return id;
	}
	
	/**
	 * Takes AirlineId and prints out AirlineName
	 * @param temp
	 * @return airline name
	 */
	public String idToAirline(String temp) {
		String id = "";
		switch(temp) {
			case "AA":
				id = "American";
				break;
			case "AF":
				id = "Air France";
				break;
			case "AS":
				id = "Alaska";
				break;
			case "BA":
				id = "British";
				break;
			case "DL":
				id = "Delta";
				break;
			case "Jl":
				id = "Japan";
				break;
			case "KL":
				id = "Royal Dutch";
				break;
			case "NH":
				id = "All Nippon";
				break;
			case "UA":
				id = "United";
				break;
			case "WN":
				id = "Southwest";
				break;
				
		}
		return id;
	}
	
	/**
	 * Changes the destination from the JTable to the id to fit in a query.
	 * @return AirportId
	 */
	public String destinationToId() {
		String id = "";
		switch(col3) {
			case "London":
				id = "EGLL";
				break;
			case "Amsterdam":
				id = "EHAM";
				break;
			case "Atlanta":
				id = "KATL";
				break;
			case "Boston":
				id = "KBOS";
				break;
			case "Denver":
				id = "KDEN";
				break;
			case "Dallas":
				id = "KDFW";
				break;
			case "New York":
				id = "KJFK";
				break;
			case "Las Vegas":
				id = "KLAS";
				break;
			case "Los Angeles":
				id = "KLAX";
				break;
			case "Miami":
				id = "KMIA";
				break;
			case "Chicago":
				id = "KORD";
				break;
			case "Portland":
				id = "KPDX";
				break;
			case "Phoenix":
				id = "KPHX";
				break;
			case "Seattle":
				id = "KSEA";
				break;
			case "San Francisco":
				id = "KSFO";
				break;
			case "Salt Lake":
				id = "KSLC";
				break;
			case "Paris":
				id = "LFPG";
				break;
			case "Tokyo1":
				id = "RJAA";
				break;
			case "Tokyo2":
				id = "RJTT";
				break;
			case "Hong Kong":
				id = "VHHH";
				break;
			case "Shanghai":
				id = "ZSPD";
				break;
		}
		return id;
	}
	
	public String idToDestination(String temp) {
		String id = "";
		switch(temp) {
			case "EGLL":
				id = "London";
				break;
			case "EHAM":
				id = "Amsterdam";
				break;
			case "KATL":
				id = "Atlanta";
				break;
			case "KBOS":
				id = "Boston";
				break;
			case "KDEN":
				id = "Denver";
				break;
			case "KDFW":
				id = "Dallas";
				break;
			case "KJFK":
				id = "New York";
				break;
			case "KLAS":
				id = "Las Vegas";
				break;
			case "KLAX":
				id = "Los Angeles";
				break;
			case "KMIA":
				id = "Miami";
				break;
			case "KORD":
				id = "Chicago";
				break;
			case "KPDX":
				id = "Portland";
				break;
			case "KPHX":
				id = "Phoenix";
				break;
			case "KSEA":
				id = "Seattle";
				break;
			case "KSFO":
				id = "San Francisco";
				break;
			case "KSLC":
				id = "Salt Lake";
				break;
			case "LFPG":
				id = "Paris";
				break;
			case "RJAA":
				id = "Tokyo1";
				break;
			case "RJTT":
				id = "Tokyo2";
				break;
			case "VHHH":
				id = "Hong Kong";
				break;
			case "ZSPD":
				id = "Shanghai";
				break;
		}
		return id;
	}
	
	/**
	 * Changes the destination from the JTable to the id to fit in a query.
	 * @return AirportId
	 */
	public String destinationToId(Object object) {
		String id = "";
		switch(col3) {
			case "London":
				id = "EGLL";
				break;
			case "Amsterdam":
				id = "EHAM";
				break;
			case "Atlanta":
				id = "KATL";
				break;
			case "Boston":
				id = "KBOS";
				break;
			case "Denver":
				id = "KDEN";
				break;
			case "Dallas":
				id = "KDFW";
				break;
			case "New York":
				id = "KJFK";
				break;
			case "Las Vegas":
				id = "KLAS";
				break;
			case "Los Angeles":
				id = "KLAX";
				break;
			case "Miami":
				id = "KMIA";
				break;
			case "Chicago":
				id = "KORD";
				break;
			case "Portland":
				id = "KPDX";
				break;
			case "Phoenix":
				id = "KPHX";
				break;
			case "Seattle":
				id = "KSEA";
				break;
			case "San Francisco":
				id = "KSFO";
				break;
			case "Salt Lake":
				id = "KSLC";
				break;
			case "Paris":
				id = "LFPG";
				break;
			case "Tokyo1":
				id = "RJAA";
				break;
			case "Tokyo2":
				id = "RJTT";
				break;
			case "Hong Kong":
				id = "VHHH";
				break;
			case "Shanghai":
				id = "ZSPD";
				break;
		}
		return id;
	}
	public int statusToId(Object object) {
		int status = 0;
		switch(col4) {
		case "On time":
			status = 0;
			break;
		case "Now Boarding":
			status = 1;
			break;
		case "Delayed":
			status = 2;
			break;
		case "Canceled":
			status = 3;
			break;
		}
		
		return status;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public String getCol6() {
		return col6;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}

	public String getCol7() {
		return col7;
	}

	public void setCol7(String col7) {
		this.col7 = col7;
	}

	public String getCol8() {
		return col8;
	}

	public void setCol8(String col8) {
		this.col8 = col8;
	}

	@Override
	public String toString() {
		return  col1 + "  " + col2 + "  " + col3 + "  " + col4 + "  " + col5
				+ "  " + col6 + "  " + col7 + "  " + col8;
	}
	
	


}
