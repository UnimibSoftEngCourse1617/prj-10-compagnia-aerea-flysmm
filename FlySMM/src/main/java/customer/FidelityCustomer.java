package customer;

import java.util.Date;

public class FidelityCustomer extends Customer {

	private int point;
	protected State state;

	public FidelityCustomer(Customer c) {
		super(c.getIdCustomer(), c.getName(), c.getSurname(), c.getEmail(), c.getPassword(), c.getPhoneNumber(),
				c.getDateOfBirth());
		this.setPoint(0);
		this.state = setFidelity(state);

	}

	public State setFidelity(State state) {
		return this.state = state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
