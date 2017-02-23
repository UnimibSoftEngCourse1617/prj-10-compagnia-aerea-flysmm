package customer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FidelityState extends State implements Serializable {

	private Date actualDateFidelity;

	public FidelityState(FidelityCustomer c) {
		super(c);
		this.actualDateFidelity = new Date();
		c.type = this.type();
	}

	// serve per cambiare lo stato da fidelity ad unfidelity
	public void changeFidelity() {
		long days = getDateDiff(this.actualDateFidelity, c.lastestBook, TimeUnit.DAYS);
		if (days > (365 * 2)) {
			c.setState(new UnfidelityState(c));
		}

	}

	@Override
	public String type() {
		return "Fidelity Customer";
	}

}
