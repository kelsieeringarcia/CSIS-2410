package flights;

public class Departure {
	private int departureId;
	private String airlineId;
	private int flightNumber;
	private String destination;
	private int status;
	private String gate;
	private String date;
	private String time;
	private int duration;
	
	public Departure(int departureId, String airlineId, int flightNumber, String destination, int status, 
			String gate, String date, String time, int duration) {
		this.departureId = departureId;
		this.airlineId = airlineId;
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.status = status;
		this.gate = gate;
		this.date = date;
		this.time = time;
		this.duration = duration;
	}

	public int getDepartureId() {
		return departureId;
	}


	public String getAirlineId() {
		return airlineId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDesination() {
		return destination;
	}

	public void setDesination(String desination) {
		this.destination = desination;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
