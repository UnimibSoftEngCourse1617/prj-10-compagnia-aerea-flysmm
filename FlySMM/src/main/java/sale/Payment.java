package sale;

import java.util.Date;

public class Payment {
	private String cardNumber;
	private String cvv;
	private String owner;
	private String address;
	private Date expiredDate;
	
	public Payment(String cardNumber, String cvv, String owner, String address, Date expiredDate) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.owner = owner;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}
	
}
