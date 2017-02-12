package promotion;

import java.sql.Date;

public class SeasonPromotion extends Promotion{
	private Date startDate;
	private Date expireDate;
	
	public String notify_() { return "Ci sono nuove promozioni in questo periodo!"; }
}