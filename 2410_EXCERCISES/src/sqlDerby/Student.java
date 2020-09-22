package sqlDerby;
/**
 * Student based on the data provided in the SQL table Student.
 * @author kelsiegarcia
 *
 */
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String major;
	private int gradYear;
	
	public Student(int id, String firstName, String lastName, String major, int gradYear) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.gradYear = gradYear;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMajor() {
		return major;
	}

	public int getGradYear() {
		return gradYear;
	}

	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName + " (" + major
				+ ") " + gradYear;
	}
	
	
	
}
