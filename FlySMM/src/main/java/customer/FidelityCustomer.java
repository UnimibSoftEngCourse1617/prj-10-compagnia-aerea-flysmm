package customer;

import java.util.Date;

public class FidelityCustomer extends Customer {

	private int point;
	protected State state;

	public FidelityCustomer(int idCustomer, String name, String surname, String email, String password,
			String phoneNumber, Date dateOfBirth) {
		super(idCustomer, name, surname, email, password, phoneNumber, dateOfBirth);
		this.setPoint(0);

	}

	public void setFidelity(State state) {
		this.state = state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
