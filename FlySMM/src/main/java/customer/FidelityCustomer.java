package customer;

import java.util.Date;

import sale.Address;

public class FidelityCustomer extends Customer {

	private int point;
	protected State state;
	protected Date startDate;
	protected Date lastestBook;
	
	public FidelityCustomer(){
		
	}

	public FidelityCustomer(long idCustomer, String name, String surname, Address address, String email,
			String password, String phoneNumber, Date dateOfBirth) {
		super(idCustomer, name, surname, address, email, password, phoneNumber, dateOfBirth);
		this.point = 0;
		this.startDate = new Date();
		this.state = new FidelityState(this);
	}

	public FidelityCustomer(Customer c) {
		super(c.getIdCustomer(), c.getName(), c.getSurname(), c.getAddress(), c.getEmail(), c.getPassword(),
				c.getPhoneNumber(), c.getDateOfBirth());
		this.point = 0;
		this.startDate = new Date();
		this.state = new FidelityState(this);
	}

	public void setState(State state) {
		this.state = state;
	}




	@Override
	public Address getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(Address address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	public State getState() {
		this.state.changeFidelity();
		return state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = this.point + point;
		if (this.point >= 1000) {
			// inviare una email per regalo destinazione europea
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastestBook() {
		return lastestBook;
	}

	public void setLastestBook(Date lastestBook) {
		this.lastestBook = lastestBook;
	}

	@Override
	public String toString() {
		return "FidelityCustomer [toString()=" + super.toString() + ", point=" + point + ", state=" + state
				+ ", startDate=" + startDate + ", lastestBook=" + lastestBook + "]";
	}

}
