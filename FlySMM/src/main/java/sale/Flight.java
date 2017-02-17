package sale;

import java.util.Date;
import booking.Book;


public class Flight {
	
	private Aircraft aircraft;
	private String idFlight;
	private Date departureDateTime;
	private Airport departureAirport;
	private Date arrivalDateTime;
	private Airport arrivalAirport;
	
	public Flight() {}
	
	public Flight(Aircraft aircraft, String idFlight, Date departureDateTime, Airport departureAirport,
			Date arrivalDateTime, Airport arrivalAirport, Book book) {
		super();
		this.aircraft = aircraft;
		this.idFlight = idFlight;
		this.departureDateTime = departureDateTime;
		this.departureAirport = departureAirport;
		this.arrivalDateTime = arrivalDateTime;
		this.arrivalAirport = arrivalAirport;
	}

	public Flight(String idFlight, Airport departureAirport, Airport arrivalAirport) {
		super();
		this.idFlight = idFlight;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public String getIdFlight() {
		return idFlight;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	@Override
	public String toString() {
		return "idFlight=" + idFlight + ", departureAirport=" + departureAirport.getName() + ", arrivalAirport="
				+ arrivalAirport.getName();
	}
	
}
