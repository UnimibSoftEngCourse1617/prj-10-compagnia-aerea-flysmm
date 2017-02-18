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
	// private Book book;

	public Flight() {
	}

	public Flight(Aircraft aircraft, String idFlight, Date departureDateTime, Airport departureAirport,
			Date arrivalDateTime, Airport arrivalAirport /* , Book book */) {
		super();
		this.aircraft = aircraft;
		this.idFlight = idFlight;
		this.departureDateTime = departureDateTime;
		this.departureAirport = departureAirport;
		this.arrivalDateTime = arrivalDateTime;
		this.arrivalAirport = arrivalAirport;
		// this.book = book;
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

	// public Book getBook() {
	// return book;
	// }

	@Override
	public String toString() {
		return "idFlight=" + idFlight + ", departureAirport=" + departureAirport.getName() + ", arrivalAirport="
				+ arrivalAirport.getName();
	}

}
