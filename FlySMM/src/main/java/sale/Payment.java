package sale;

import java.util.Date;
import customer.Customer;

public class Payment {
	private String cardNumber;
	private String cvv;
	private String owner;
	private Address cardOwnerAddress;
	private Date expiredDate;
	private Customer custumer;

	public Payment() {

	}

	public Payment(String cardNumber, String cvv, String owner, Address cardOwnerAddress, Date expiredDate,
			Customer customer) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.owner = owner;
		this.cardOwnerAddress = cardOwnerAddress;
		this.expiredDate = expiredDate;
		this.custumer = customer;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public String getOwner() {
		return owner;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public Address getCardOwnerAddress() {
		return cardOwnerAddress;
	}

	public Customer getCustumer() {
		return custumer;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setCardOwnerAddress(Address cardOwnerAddress) {
		this.cardOwnerAddress = cardOwnerAddress;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setCustumer(Customer custumer) {
		this.custumer = custumer;
	}

}
