package booking;

public class Passenger {
	private String name;
	private String surname;
	private long passengerId;

	public Passenger() {
		super();
	}

	public Passenger(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", document=" + passengerId;
	}

}