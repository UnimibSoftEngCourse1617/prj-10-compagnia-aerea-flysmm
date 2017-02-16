package booking;

import customer.Customer;
import sale.Flight;
import booking.Passenger;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book {
	private long bookId = 1;
	private int customerId;
	private Date bookingDate;
	private ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
	private ArrayList<Baggage> listBaggage = new ArrayList<Baggage>();
	private ArrayList<Flight> listFlight = new ArrayList<Flight>();
	private float totalPrice;
	private int payed;
	private int expired;

	private long documentP;
	private String flightId;

	public Book() {
		super();
	}

	public Book(int c, Flight f) {
		super();
		this.customerId = c;
		listFlight.add(f);
		this.bookingDate = this.getDate();
		this.payed = 0;
		this.expired = 0;
		this.totalPrice = 100;
	}

	public Book(int c, Flight f1, Flight f2) {
		super();
		this.customerId = c;
		listFlight.add(f1);
		listFlight.add(f2);
		this.bookingDate = this.getDate();
		this.payed = 0;
		this.expired = 0;
		this.totalPrice = 100;

	}

	public int getExpired() {
		return expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

	public int getPayed() {
		return payed;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setListPassenger(ArrayList<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public void setListBaggage(ArrayList<Baggage> listBaggage) {
		this.listBaggage = listBaggage;
	}

	public void setListFlight(ArrayList<Flight> listFlight) {
		this.listFlight = listFlight;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	void addPassenger(Passenger passenger) {
		this.listPassenger.add(passenger);
	}

	public ArrayList<Passenger> getListPassenger() {
		return listPassenger;
	}

	void addFlight(Flight f) {
		this.listFlight.add(f);
	}

	public ArrayList<Flight> getListFlight() {
		return listFlight;
	}

	void addBaggage(Baggage b) {
		this.listBaggage.add(b);
	}

	public ArrayList<Baggage> getListBaggage() {
		return listBaggage;
	}

	public long getBookId() {
		return bookId;
	}

	public int isPayed() {
		return payed;
	}

	public void setPayed(int payed) {
		this.payed = payed;
	}

	public int isExpired() {
		return expired;
	}

	public boolean setExpired() {
		if (Book.getDateDiff(this.getBookingDate(), this.getDate(), TimeUnit.MINUTES) > 1440) {
			this.expired = 1;
			return true;
		} else {
			this.expired = 0;

			return false;
		}
	}

	public Date setBookingDate() {
		return getDate();
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public int getTotalWeight() {
		int totalWeight = 0;
		for (Baggage b : listBaggage) {
			totalWeight += b.getWeight();
		}
		return totalWeight;
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public long getDocumentP() {
		return documentP;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setDocumentP(long documentP) {
		this.documentP = documentP;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", customerId=" + customerId + ", bookingDate=" + bookingDate
				+ ", listPassenger=" + listPassenger + ", listBaggage=" + listBaggage + ", listFlight=" + listFlight
				+ ", totalPrice=" + totalPrice + ", payed=" + payed + ", expired=" + expired + ", documentP="
				+ documentP + ", flightId=" + flightId + "]";
	}
	

}
