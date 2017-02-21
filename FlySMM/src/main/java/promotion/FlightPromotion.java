package promotion;

import sale.Flight;

public class FlightPromotion extends Promotion{
	
	private static final long serialVersionUID = 1L;
	
	private Flight flight;

	public FlightPromotion(){
		super();
	}
	
	public FlightPromotion(Flight flight){
		this.promoType = "flight";
		this.setFlight(flight);
		this.notify_("There is a new Promotion, check it out in our website");
	}
	
	public FlightPromotion(String idPromo, int discountRate, boolean fidelity, String name, String description, Flight flight){
		this.idPromo = idPromo;
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.name = name;
		this.description = description;
		this.promoType = "flight";
		this.setFlight(flight);
		this.notify_("There is a new Promotion, check it out in our website");
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