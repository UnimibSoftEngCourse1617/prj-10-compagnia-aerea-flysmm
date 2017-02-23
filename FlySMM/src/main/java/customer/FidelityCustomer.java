package customer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import promotion.Mail;
import sale.Address;

public class FidelityCustomer extends Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int point;
	protected State state;
	protected Date startDate;
	protected Date lastestBook;
	protected Date actualDateUnfidelity;
	protected String type;

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

//	Calendar today = Calendar.getInstance();
//
//
//	Timer timer = new Timer();
//	
//		public void run(){
//			today.set(Calendar.HOUR_OF_DAY,2);
//			today.set(Calendar.MINUTE,0);
//			today.set(Calendar.SECOND,0);
//			
//			timer.schedule(new FidelityCustomer(),today.getTime(),TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS)); 
//		}
													

	public Date getActualDateUnfidelity() {
		return actualDateUnfidelity;
	}

	public void setActualDateUnfidelity(Date actualDateUnfidelity) {
		this.actualDateUnfidelity = actualDateUnfidelity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FidelityCustomer() {
		super();
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public Address getAddress() {

		return super.getAddress();
	}

	@Override
	public void setAddress(Address address) {

		super.setAddress(address);
	}

	public State getState() {
		this.state.changeFidelity();
		return state;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) throws MessagingException {
		this.point = this.point + point;
		if (this.point >= 1000) {
			// inviare una email per regalo destinazione europea

			Mail m = new Mail();
			m.sendMail(this.getEmail(),
					"Hai raggiunto i mille punti bonus, hai vinto un viaggio per una destinazione europea a tua scelta! Congratulazioni");

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

	public void changeFidelity() {
		state.changeFidelity();

	}

}
