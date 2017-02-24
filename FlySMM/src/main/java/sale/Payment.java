package sale;

import java.io.Serializable;
import java.util.Date;
import customer.Customer;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cardNumber;
	private Customer customer;
	private String cvv;
	private String owner;
	private Date expiredDate;

	public Payment() {
		super();
	}

	public Payment(int cardNumber, Customer customer, String cvv, String owner, Date expiredDate) {
		super();
		this.cardNumber = cardNumber;
		this.customer = customer;
		this.cvv = cvv;
		this.owner = owner;
		this.expiredDate = expiredDate;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	
}
