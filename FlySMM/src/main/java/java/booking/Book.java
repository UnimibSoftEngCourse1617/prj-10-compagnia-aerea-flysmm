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
	private Customer customer;
	private Flight flight;
	private boolean payed;
	private boolean expired;
	private Date bookingDate;
	private ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
	private ArrayList<Baggage> listBaggage = new ArrayList<Baggage>();
	private float totalPrice;

	public Book(Customer c, Flight f) {
		super();
		Passenger p = new Passenger(c.getName(), c.getSurname(), "ABC123DEF");
		this.bookId = setBookId(f.getDepartureAirport().getName(), f.getArrivalAirport().getName());
		this.customer = c;
		this.flight = f;
		this.bookingDate = setBookingDate();
		addPassenger(p);

	}

	private String setBookId(String airport, String airport2) {
		String bookId = airport.substring(0, 3) + airport2.substring(0, 3);
		return bookId;

	}

	void addPassenger(Passenger passenger) {
		this.listPassenger.add(passenger);
	}

	void addBaggage(Baggage b) {
		this.listBaggage.add(b);
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

	public int getTotalWeight() {
		int totalWeight = 0;
		for (Baggage b : listBaggage) {
			totalWeight += b.getWeight();
		}
		return totalWeight;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", customer=" + customer + ", flight=" + flight.toString() + ", bookingDate="
				+ bookingDate + ", listPassenger=" + listPassenger.toString() + ", listBaggage="
				+ listBaggage.toString() + "]";
	}

}
