package promotion;

import java.util.Date;

public class SeasonPromotion extends Promotion{
	private Date startDate;
	private Date expireDate;
	
	public void notify_() {
		for(int i=0; i < 1000;i++)
			//if customer is fidelity
			if(true)
				//get address
				this.sendMail("address");
		}
	
	public SeasonPromotion(){}
	
	public SeasonPromotion(Date startDate, Date expireDate){
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
		this.notify_();
	}
	
	public SeasonPromotion(int discountRate, boolean fidelity, long idPromo, String name, Date startDate, Date expireDate){
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.idPromo = idPromo;
		this.name = name;
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
		this.notify_();
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