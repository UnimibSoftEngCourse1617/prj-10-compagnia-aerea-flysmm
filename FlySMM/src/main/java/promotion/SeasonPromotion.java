package promotion;

import java.sql.Date;

public class SeasonPromotion extends Promotion{
	private Date startDate;
	private Date expireDate;
	
	public String notify_() { return "Ci sono nuove promozioni in questo periodo!"; }
	public SeasonPromotion(Date startDate, Date expireDate){
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
	}
	public SeasonPromotion(int discountRate, boolean fidelity, long idPromo, String name, Date startDate, Date expireDate){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
}