package customer;

import java.time.LocalDate;

public class FidelityCustomer extends Customer {

	private int point;
	protected String state;
	protected LocalDate startDate;
	public FidelityCustomer(Customer c) {
		super(c.getIdCustomer(), c.getName(), c.getSurname(), c.getEmail(), c.getPassword(), c.getPhoneNumber(),
				c.getDateOfBirth());
		this.point = 0;
		this.state = "Fidelity";
		this.startDate = LocalDate.now();

	}

	public String setFidelity(String state) {
		return this.state = state;
	}

	public String getState() {
		return state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "FidelityCustomer [getIdCustomer()=" + getIdCustomer() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getDateOfBirth()=" + getDateOfBirth() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", point=" + point
				+ ", state=" + state + ", localDate=" + startDate.lengthOfYear() + "]";
	}

}
