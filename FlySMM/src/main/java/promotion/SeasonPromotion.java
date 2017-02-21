package promotion;

import java.util.Date;

public class SeasonPromotion extends Promotion{
	private Date startDate;
	private Date expireDate;
	
	public void notify_() {
		Mail m = new Mail();
		m.sendMail("mail", "new S Promo");
		}
	
	public SeasonPromotion(){
		super();
	}
	
	public SeasonPromotion(Date startDate, Date expireDate){
		this.promoType = "season";
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
		this.notify_("There is a new Promotion in this period, check it out in our website");
	}
	
	public SeasonPromotion(String idPromo, int discountRate, boolean fidelity, String name, String description, Date startDate, Date expireDate){
		this.idPromo = idPromo;
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.name = name;
		this.description = description;
		this.promoType = "season";
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
		this.notify_("There is a new Promotion in this period, check it out in our website");
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
	
	@Override
	public String toString() {
		return "SeasonPromotion [getIdPromo()=" + getIdPromo() + ", getDiscountRate()=" + getDiscountRate() + ", getFidelity()="
				+ isFidelity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getStartDate()=" + getStartDate() + ", getExpireDate()="
				+ getExpireDate()+ "]";
	}
}