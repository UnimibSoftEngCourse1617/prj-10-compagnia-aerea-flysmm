package customer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FidelityState extends State implements Serializable {

	private Date actualDateFidelity;

	public FidelityState(FidelityCustomer c) {
		super(c);
		this.actualDateFidelity = new Date();
		c.type=this.type();
	}

	// serve per cambiare lo stato da fidelity ad unfidelity
	public void changeFidelity() {

		if ((getDateDiff(this.actualDateFidelity, c.startDate, TimeUnit.DAYS)) > 365) {
			c.setState(new UnfidelityState(c));
		}

	}

	@Override
	public String type() {
		return "Fidelity Customer";
	}

}
