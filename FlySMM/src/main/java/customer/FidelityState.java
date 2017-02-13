package customer;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FidelityState extends State {

	private Date actualDate;

	public FidelityState(FidelityCustomer c) {
		super(c);
		this.actualDate= new Date(); 
	}

	// serve per cambiare lo stato da fidelity ad unfidelity
	public void changeFidelity() {
		if (getDateDiff(c.startDate, this.actualDate, TimeUnit.MINUTES) > 365){
			c.setFidelity(new UnfidelityState(c));
		} else {
	
		}
		
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
