/*
 * TODO: modificare il diagramma delle classi aggiunta classe Andress
 * */

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

	public String getIcao() {
		return icao;
	}

	public String getName() {
		return name;
	}

	
}
