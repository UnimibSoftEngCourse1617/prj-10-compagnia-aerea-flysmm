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
	private Book book; // ho bisogno di avere tutte le prenotazioni di un volo ? //Secondo me no... (dbbd59)
	
	public Flight(Aircraft aircraft, String idFlight, Date departureDateTime, Airport departureAirport,
			Date arrivalDateTime, Airport arrivalAirport, Book book) {
		super();
		this.aircraft = aircraft;
		this.idFlight = idFlight;
		this.departureDateTime = departureDateTime;
		this.departureAirport = departureAirport;
		this.arrivalDateTime = arrivalDateTime;
		this.arrivalAirport = arrivalAirport;
		this.book = book;
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

	public Book getBook() {
		return book;
	}
	
}
