package booking;

import customer.Customer;
import sale.Flight;
import sale.Passenger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Book {
	private String bookId;
	private Customer userId;
	private Flight flightId;
	private boolean payed;
	private boolean expired;
	private Date bookingDate;
	private ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
	private float totalPrice;

	public Book(Customer userId, Flight flightId) {
		super();
		this.bookId = setBookId(flightId.getDepartureAirport().toString(), flightId.getArrivalAirport().toString());
		this.userId = userId;
		this.flightId = flightId;
		this.bookingDate = setBookingDate();
	}

	private String setBookId(String airport, String airport2) {
		String bookId = airport.substring(0, 3) + airport2.substring(0, 3);
		return bookId;

	}

	private void addPassenger(Passenger passenger) {
		this.listPassenger.add(passenger);
	}

	public String getBookId() {
		return bookId;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public Date setBookingDate() {
		return getDate();
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
