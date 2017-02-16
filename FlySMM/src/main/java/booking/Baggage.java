package booking;

public class Baggage {
	private long baggageId = 1;
	private int weight;
	private long passengerId;
	private long bookId;
	private int customerId;
	private String flightId;

	public Baggage() {
		super();
	}

	public Baggage(Passenger p, Book b,int weight) {
		super();
		this.weight = weight;
		this.passengerId = p.getDocument();
		this.bookId = b.getBookId();
		this.customerId = b.getCustomerId();
		this.flightId = b.getFlightId();
	}

	public long getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(long baggageId) {
		this.baggageId = baggageId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Baggage [baggageId=" + baggageId + ", weight=" + weight + ", passengerId=" + passengerId + ", bookId="
				+ bookId + ", customerId=" + customerId + ", flightId=" + flightId + "]";
	}

}
