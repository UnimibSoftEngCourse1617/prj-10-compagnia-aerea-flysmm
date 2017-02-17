package promotion;

public class FlightPromotion extends Promotion{
	private long idFlight;
	
	public void notify_() {
		this.sendMail("mail");
		}

	public FlightPromotion(){}
	
	public FlightPromotion(long idFlight){
		this.PromoType = "flight";
		this.setIdFlight(idFlight);
	}
	
	public FlightPromotion(long idPromo, int discountRate, boolean fidelity, String name, String description, long idFlight){
		this.idPromo = idPromo;
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.name = name;
		this.description = description;
		this.PromoType = "flight";
		this.setIdFlight(idFlight);
	}
	
	public long getIdFlight() {
		return idFlight;
	}
	
	public void setIdFlight(long idFlight) {
		this.idFlight = idFlight;
	}
	
	@Override
	public String toString() {
		return "SeasonPromotion [getIdPromo()=" + getIdPromo() + ", getDiscountRate()=" + getDiscountRate() + ", getFidelity()="
				+ isFidelity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getIdFlight()=" + getIdFlight() + "]";
	}
}