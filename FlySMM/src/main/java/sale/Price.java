package sale;

import java.io.Serializable;

import promotion.Promotion;

public class Price implements Serializable{
	private Flight flight;
	private Seat seat;
	private Promotion promo;
	private float amount;

	public Price() {
	}

	public Price(Flight flight, Seat seat, Promotion promo, float amount) {
		super();
		this.flight = flight;
		this.seat = seat;
		this.promo = promo;
		this.amount = amount;
		
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Promotion getPromo() {
		return promo;
	}

	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}