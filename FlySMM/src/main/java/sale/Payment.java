package sale;

import java.util.Date;
import booking.Book;

public class Payment {
	private String cardNumber;
	private String cvv;
	private String owner;
	private Address cardOwnerAddress;
	private Date expiredDate;
	private Book book;
	
	public Payment(String cardNumber, String cvv, String owner, Address cardOwnerAddress, Date expiredDate, Book book) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.owner = owner;
		this.cardOwnerAddress = cardOwnerAddress;
		this.expiredDate = expiredDate;
		this.book = book;
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
	
	public Book getBook() {
		return book;
	}
}
