package booking;

import customer.Customer;
import sale.Flight;
import booking.Passenger;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book {
	private long bookId = 1;
	private Customer customer;
	private Date bookingDate;
	private ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
	private ArrayList<Baggage> listBaggage = new ArrayList<Baggage>();
	private ArrayList<Flight> listFlight = new ArrayList<Flight>();
	private float totalPrice;
	private boolean payed;
	private boolean expired;

	public Book() {
		super();
	}

	public Book(Customer c, Flight f) {
		super();
		this.customer = c;
		listFlight.add(f);
		this.bookingDate = this.getDate();
		this.payed = false;
		this.expired = false;
	}

	public Book(Customer c, Flight f1, Flight f2) {
		super();
		this.customer = c;
		listFlight.add(f1);
		listFlight.add(f2);
		this.bookingDate = this.getDate();
		this.payed = false;
		this.expired = false;
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

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public boolean isExpired() {
		return expired;
	}

	public boolean setExpired() {
		if (Book.getDateDiff(this.getBookingDate(), this.getDate(), TimeUnit.MINUTES) > 1440) {
			this.expired = true;
			return true;
		} else {
			this.expired = false;

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

	@Override
	public String toString() {
		return "Book\nbookId=" + bookId + ", bookingDate=" + bookingDate + "\nlistPassenger=" + listPassenger.toString()
				+ ", \nlistBaggage=" + listBaggage.toString() + ", \nlistFlight=" + listFlight.toString() + ", \npayed=" + payed
				+ ", \nexpired=" + expired;
	}

}
