package booking;

import customer.Customer;
import sale.Flight;
import booking.Passenger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Book implements Serializable{
	private String bookId;
	private long customerId;
	private Date bookingDate;
	private float totalPrice;
	private int payedB;
	private int expiredB;
	private int airplaneId;
	private Date departureDate;
	private String documentP;
	private String flightId;

	
	public Book() {
		super();
	}

	public Book(Customer c, Flight f, Passenger p) {
		super();
		this.bookId = this.createBookId(f, c, p);
		this.customerId = c.getIdCustomer();
		this.bookingDate = this.getDate();
		this.totalPrice = 0;
		this.payedB = 0;
		this.expiredB = 0;
		this.airplaneId = f.getAircraft().getIdAircraft();
		this.departureDate = f.getDepartureDateTime();
		this.documentP = p.getFiscal_code();
		this.flightId = f.getIdFlight();

	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPayed() {
		return payedB;
	}

	public void setPayed(int payed) {
		this.payedB = payed;
	}

	public int getExpired() {
		return expiredB;
	}

	public void setExpired(int expired) {
		this.expiredB = expired;
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

	public String getDocumentP() {
		return documentP;
	}

	public void setDocumentP(String documentP) {
		this.documentP = documentP;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String createBookId(Flight f, Customer c, Passenger p) {
		String s = f.getDepartureAirport().getIcao() + f.getArrivalAirport().getIcao() + f.getIdFlight()
				+ c.getIdCustomer() + p.getFiscal_code().substring(0, 6);
		return s;

	}

	public boolean verifyExpired() {
		if (Book.getDateDiff(this.getBookingDate(), this.getDate(), TimeUnit.MINUTES) > 1440) {
			this.expiredB = 1;
			return true;
		} else {
			this.expiredB = 0;
			return false;
		}
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
		return "Book [bookId=" + bookId + ", customerId=" + customerId + ", bookingDate=" + bookingDate
				+ ", totalPrice=" + totalPrice + ", payed=" + payedB + ", expired=" + expiredB + ", airplaneId="
				+ airplaneId + ", departureDate=" + departureDate + ", documentP=" + documentP + ", flightId="
				+ flightId + "]";
	}

}
