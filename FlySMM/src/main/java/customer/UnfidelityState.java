package customer;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnfidelityState extends State {

	private Date actualDateUnfidelity;
	
	public UnfidelityState(FidelityCustomer c) {
		super(c);
		this.actualDateUnfidelity= new Date(); 


	}
	@Override
	public void changeFidelity() {
		if ((getDateDiff(this.actualDateUnfidelity, c.startDate, TimeUnit.MINUTES)/ (1000*60*60*24)) > (365*2)) {
			c.setFidelity(new UnfidelityState(c));
		}
		 
		
	}

	

}
