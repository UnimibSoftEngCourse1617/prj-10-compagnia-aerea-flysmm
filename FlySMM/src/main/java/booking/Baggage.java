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
		this.setBook(b);
		this.passenger = p;
		this.weight = weight;
		this.baggageId = 1;
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

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Baggage [baggageId=" + baggageId + ", weight=" + weight + ", passenger=" + passenger.toString() + "]";
	}

}
