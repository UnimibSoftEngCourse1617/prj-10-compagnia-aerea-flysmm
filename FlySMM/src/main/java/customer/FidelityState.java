package customer;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FidelityState extends State {

	private Date actualDateFidelity;

	public FidelityState(FidelityCustomer c) {
		super(c);
		this.actualDateFidelity = new Date();
	}

	// serve per cambiare lo stato da fidelity ad unfidelity
	public void changeFidelity() {

		if ((getDateDiff(this.actualDateFidelity, c.startDate, TimeUnit.DAYS)) > 365) {
			c.setFidelity(new UnfidelityState(c));
		}

	}

	@Override
	public String type() {
		return "Fidelity Customer";
	}

}
