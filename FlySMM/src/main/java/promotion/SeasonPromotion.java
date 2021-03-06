package promotion;

import java.util.Date;

import javax.mail.MessagingException;

public class SeasonPromotion extends Promotion{
	
	private static final long serialVersionUID = 1L;
	
	private Date startDate;
	private Date expireDate;
	
	public SeasonPromotion(){
		super();
	}
	
	public SeasonPromotion(Date startDate, Date expireDate) throws MessagingException{
		this.promoType = "season";
		this.setStartDate(startDate);
		this.setExpireDate(expireDate);
		this.notify_("There is a new Promotion in this period, check it out in our website");
	}
	
	public SeasonPromotion(String idPromo, int discountRate, boolean fidelity, String name, String description, Date startDate, Date expireDate) throws MessagingException{
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