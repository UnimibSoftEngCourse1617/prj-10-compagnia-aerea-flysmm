package promotion;

import sale.Flight;

public class FlightPromotion extends Promotion{
	private Flight flight;
	
	public void notify_() {
		this.sendMail("mail");
		}

	public FlightPromotion(){}
	
	public FlightPromotion(Flight flight){
		this.setFlight(flight);
	}
	
	public FlightPromotion(int discountRate, boolean fidelity, long idPromo, String name, Flight flight){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setFlight(flight);
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}