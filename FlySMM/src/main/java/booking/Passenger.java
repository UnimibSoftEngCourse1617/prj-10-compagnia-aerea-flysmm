package booking;

public class Passenger {
	private String name;
	private String surname;
	private String document;

	public Passenger() {
		super();
	}

	public Passenger(String name, String surname, String document) {
		super();
		this.name = name;
		this.surname = surname;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDocument() {
		return document;
	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", document=" + document;
	}

}