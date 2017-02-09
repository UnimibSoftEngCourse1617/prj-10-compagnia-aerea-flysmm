package sale;

import java.util.TimeZone;

public class Airport {
	// da modificare la relazione forse è sbagliata controllare e sistemare diagramma 
	private Flight departureflight; 
	private Flight arrivalflight;
	private String icao;
	private String name;
	private String city;
	private String country;
	private TimeZone timezone;
	
	public Airport(Flight departureflight, Flight arrivalflight, String icao, String name, String city, String country,
			TimeZone timezone) {
		super();
		this.departureflight = departureflight;
		this.arrivalflight = arrivalflight;
		this.icao = icao;
		this.name = name;
		this.city = city;
		this.country = country;
		this.timezone = timezone;
	}

	public Flight getDepartureflight() {
		return departureflight;
	}

	public Flight getArrivalflight() {
		return arrivalflight;
	}

	public String getIcao() {
		return icao;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public TimeZone getTimezone() {
		return timezone;
	}
	
}
