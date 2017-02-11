package sale;

import java.util.Date;

public class Payment {
	private String cardNumber;
	private String cvv;
	private String owner;
	private Address cardOwnerAddress;
	private Date expiredDate;
	
	public Payment(String cardNumber, String cvv, String owner, Address cardOwnerAddress, Date expiredDate) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.owner = owner;
		this.cardOwnerAddress = cardOwnerAddress;
		this.expiredDate = expiredDate;
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

	public Address getCardOwerAddress() {
		return cardOwnerAddress;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}
	
}
