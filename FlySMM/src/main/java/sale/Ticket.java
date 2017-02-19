package sale;

import booking.Book;
import booking.Passenger;

public class Ticket {
	private Passenger passenger;
	private Book book;
	private Seat seat;

	public Ticket() {

	}

	public Ticket(Passenger passenger, Book book, Seat seat) {
		this.passenger = passenger;
		this.book = book;
		this.seat = seat;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
  
}