package sale;
import booking.Book;
import booking.Passenger;

public class Ticket {
	private Passenger passenger;
	private Book book;

	public Ticket(Passenger passenger, Book book) {
		super();
		this.passenger = passenger;
		this.book = book;
	}

	public Passenger getPassenger() {
		return passenger;
	}
	
	public Book getBook(){
		return book;
	}
	
	

}
