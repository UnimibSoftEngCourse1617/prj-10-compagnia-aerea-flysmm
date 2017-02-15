package promotion;

public class FlightPromotion extends Promotion{
	private long idFlight;
	
	public void notify_() {
		for(int i=0; i < 1000;i++)
			//if customer is fidelity
			if(true)
				//get address
				this.sendMail("address");
		}

	public FlightPromotion(){}
	
	public FlightPromotion(long idFlight){
		this.setIdFlight(idFlight);
		this.notify_();
	}
	
	public FlightPromotion(int discountRate, boolean fidelity, long idPromo, String name, long idFlight){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setIdFlight(idFlight);
		this.notify_();
	}
	
	public long getIdFlight() {
		return idFlight;
	}
	
	public void setIdFlight(long idFlight) {
		this.idFlight = idFlight;
	}
}