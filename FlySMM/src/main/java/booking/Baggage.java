package booking;

import booking.Passenger;

public class Baggage {
	private int baggageId;
	private int weight;
	private Passenger passenger;
	private Book book;

	public Baggage() {
		super();
	}

	public Baggage(Book b, Passenger p, int weight) {
		super();
		this.baggageId = 1;
		this.book = b;
		this.passenger = p;
		this.weight = weight;

	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBaggageId() {
		return baggageId;
	}

	public Book getBook() {
		return book;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	@Override
	public String toString() {
		return "baggageId=" + baggageId + ", weight=" + weight + ", passenger=" + passenger.getSurname() + ", book="
				+ book.getBookId();
	}

}
