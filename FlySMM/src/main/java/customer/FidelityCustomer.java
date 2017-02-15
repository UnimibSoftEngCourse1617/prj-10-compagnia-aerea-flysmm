package customer;

import java.util.Date;

public class FidelityCustomer extends Customer {

	private int point;
	protected State state;
	protected Date startDate;
	protected Date lastestBook;

	public FidelityCustomer(int idCustomer, String name, String surname, String email, String password,
			String phoneNumber, Date dateOfBirth) {
		super(idCustomer, name, surname, email, password, phoneNumber, dateOfBirth);
		this.point = 0;
		this.startDate = new Date();
		this.state = new FidelityState(this);
	}

	public FidelityCustomer(Customer c) {
		super(c.getIdCustomer(), c.getName(), c.getSurname(), c.getEmail(), c.getPassword(), c.getPhoneNumber(),
				c.getDateOfBirth());
		this.point = 0;
		this.startDate = new Date();
		this.state = new FidelityState(this);
	}

	public void setFidelity(State state) {
		this.state = state;
	}

	public State getState() {
		this.state.changeFidelity();
		return state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "FidelityCustomer [getIdCustomer()=" + getIdCustomer() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getDateOfBirth()=" + getDateOfBirth()
				 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", point=" + point
				+ ", state=" + state + ", localDate=" + startDate.getTime() + "]";
	}

}
