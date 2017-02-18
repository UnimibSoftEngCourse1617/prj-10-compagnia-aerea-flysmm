package promotion;

import sale.Flight;

public class FlightPromotion extends Promotion{
	private Flight flight;
	
	public void notify_() {
		this.sendMail("mail");
		}

	public FlightPromotion(){}
	
	public FlightPromotion(Flight flight){
		this.promoType = "flight";
		this.setFlight(flight);
	}
	
	public FlightPromotion(long idPromo, int discountRate, boolean fidelity, String name, String description, Flight flight){
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
		return "SeasonPromotion [getIdPromo()=" + getIdPromo() + ", getDiscountRate()=" + getDiscountRate() + ", getFidelity()="
				+ isFidelity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getIdFlight()=" + getFlight() + "]";
	}

}