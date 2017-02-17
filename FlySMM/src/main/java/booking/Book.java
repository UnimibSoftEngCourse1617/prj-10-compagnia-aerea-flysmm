package booking;

import customer.Customer;
import sale.Flight;
import booking.Passenger;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book {
	private long bookId = 1;
	private long customerId;
	private Date bookingDate;
	private float totalPrice;
	private int payed;
	private int expired;
	private int airplaneId;
	private Date departureDate;
	private String documentP;
	private String flightId;

	public Book() {
		super();
	}

	public Book(Customer c, Flight f, Passenger p) {
		super();
		this.customerId = c.getIdCustomer();
		this.bookingDate = this.getDate();
		this.totalPrice = 0;
		this.payed = 0;
		this.expired = 0;
		this.airplaneId = f.getAircraft().getIdAircraft();
		this.departureDate = f.getDepartureDateTime();
		this.documentP = p.getFiscal_code();
		this.flightId = f.getIdFlight();

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

	public void setCustomerId(long l) {
		this.customerId = l;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getBookId() {
		return bookId;
	}

	public int isPayed() {
		return payed;
	}

	public int getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
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

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public String getDocumentP() {
		return documentP;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setDocumentP(String documentP) {
		this.documentP = documentP;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", customerId=" + customerId + ", bookingDate=" + bookingDate
				+ ", totalPrice=" + totalPrice + ", payed=" + payed + ", expired=" + expired + ", airplaneId="
				+ airplaneId + ", departureDate=" + departureDate + ", documentP=" + documentP + ", flightId="
				+ flightId + ", getExpired()=" + getExpired() + ", getPayed()=" + getPayed() + ", getCustomerId()="
				+ getCustomerId() + ", getBookId()=" + getBookId() + ", isPayed()=" + isPayed() + ", getAirplaneId()="
				+ getAirplaneId() + ", getDepartureDate()=" + getDepartureDate() + ", isExpired()=" + isExpired()
				+ ", setExpired()=" + setExpired() + ", setBookingDate()=" + setBookingDate() + ", getBookingDate()="
				+ getBookingDate() + ", getTotalPrice()=" + getTotalPrice() + ", getDate()=" + getDate()
				+ ", getDocumentP()=" + getDocumentP() + ", getFlightId()=" + getFlightId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
