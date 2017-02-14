package booking;

import sale.Passenger;

public class Baggage {
	private int baggageId;
	private int weight;
	private Passenger passenger;

	public Baggage(Passenger p, int weight) {
		super();
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

	@Override
	public String toString() {
		return "Baggage [baggageId=" + baggageId + ", weight=" + weight + ", passenger=" + passenger.toString() + "]";
	}
	

}
