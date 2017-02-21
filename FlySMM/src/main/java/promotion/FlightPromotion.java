package promotion;

import sale.Flight;

public class FlightPromotion extends Promotion{
	private Flight flight;
	
	public void notify_() {
		Mail m = new Mail();
		m.sendMail("mail","new F Promo");
		}

	public FlightPromotion(){}
	
	public FlightPromotion(Flight flight){
		this.promoType = "flight";
		this.setFlight(flight);
	}
	
	public FlightPromotion(String idPromo, int discountRate, boolean fidelity, String name, String description, Flight flight){
		this.idPromo = idPromo;
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.name = name;
		this.description = description;
		this.promoType = "flight";
		this.setFlight(flight);
	}
	
	public Flight getFlight() {
		return this.flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "FlightPromotion [getIdPromo()=" + getIdPromo() + ", getDiscountRate()=" + getDiscountRate() + ", getFidelity()="
				+ isFidelity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getFlight()=" + getFlight() + "]";
	}

}