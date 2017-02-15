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
	//private Date d = new Date((long) 1485345898343.0);

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

	void addFlight(Flight f) {
		this.listFlight.add(f);
	}

	void addBaggage(Baggage b) {
		this.listBaggage.add(b);
	}

	public long getBookId() {
		return bookId;
	}

	public boolean isPayed() {
		return payed;
	}

	public boolean isExpired() {
		if (Book.getDateDiff(this.getBookingDate(), this.getDate(), TimeUnit.MINUTES) > 1440)
			return true;
		else
			return false;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
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

	public ArrayList<Baggage> getListBaggage() {
		return listBaggage;
	}

	public void setListBaggage(ArrayList<Baggage> listBaggage) {
		this.listBaggage = listBaggage;
	}

	public ArrayList<Passenger> getListPassenger() {
		return listPassenger;
	}

	public ArrayList<Flight> getListFlight() {
		return listFlight;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", customer=" + customer + ", bookingDate=" + bookingDate + ", listPassenger="
				+ listPassenger + ", listBaggage=" + listBaggage + ", listFlight=" + listFlight + "]";
	}

}
