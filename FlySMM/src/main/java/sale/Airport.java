package sale;

public class Airport {
	
	private String icao;
	private String name;
	private Address airportAndress; 
	
	
	public Airport(String icao, String name, Address airportAndress) {
		super();
		this.icao = icao;
		this.name = name;
		this.airportAndress = airportAndress;
	}

	public Airport(String icao, String name) {
		super();
		this.icao = icao;
		this.name = name;
	}

	public String getIcao() {
		return icao;
	}

	public String getName() {
		return name;
	}
	
	public Address getAirportAndress() {
		return airportAndress;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}
}
