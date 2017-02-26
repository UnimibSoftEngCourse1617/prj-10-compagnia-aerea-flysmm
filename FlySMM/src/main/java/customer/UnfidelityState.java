package customer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnfidelityState extends State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;

	public UnfidelityState(FidelityCustomer c) {
		super(c);
		c.actualDateUnfidelity = new Date();
		c.type = this.type();
	}

	@Override
	public void changeFidelity() {

		long temp = getDateDiff(c.actualDateUnfidelity, c.lastestBook, TimeUnit.DAYS);
		if (temp > 365) {
			this.customer = new Customer(c);
		} else {
			c.setState(new FidelityState(c));
		}

	}

	@Override
	public String type() {
		return "Unfidelity Customer";
	}

}
