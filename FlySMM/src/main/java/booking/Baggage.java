package booking;

public class Baggage {
	private String baggageId;
	private int weight;
	private int price;

	public Baggage() {
		super();
	}

	public Baggage(String baggageId, int weight, int price) {
		super();
		this.baggageId = baggageId;
		this.weight = weight;
		this.price = price;
	}

	public String getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(String baggageId) {
		this.baggageId = baggageId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
