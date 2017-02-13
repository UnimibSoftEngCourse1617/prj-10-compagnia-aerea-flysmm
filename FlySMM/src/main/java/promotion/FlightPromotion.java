package promotion;

public class FlightPromotion extends Promotion{
	private String idFlight;
	
	public String notify_() { return "Nuova offerta sul volo X!"; }
	public FlightPromotion(String idFlight){
		this.setIdFlight(idFlight);
	}
	public FlightPromotion(int discountRate, boolean fidelity, int idPromo, String name, String idFlight){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setIdFlight(idFlight);
	}
	public String getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}
}