package booking;

public class Baggage {
	private long baggageId = 1;
	private int weight;

	public Baggage() {
		super();
	}

	public Baggage(int weight) {
		super();
		this.weight = weight;
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

}
