package promotion;

public class FlightPromotion extends Promotion{
	private long idFlight;
	
	public String notify_() { return "Nuova offerta sul volo X!"; }
	public FlightPromotion(long idFlight){
		this.setIdFlight(idFlight);
	}
	public FlightPromotion(int discountRate, boolean fidelity, long idPromo, String name, long idFlight){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setIdFlight(idFlight);
	}
	public long getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(long idFlight) {
		this.idFlight = idFlight;
	}
}