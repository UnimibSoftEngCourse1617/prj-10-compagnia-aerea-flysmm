package sale;

import booking.Book;

public class Passenger {
	private Book book;
	private String name;
	private String surname;
	private String fiscalcode;

	public Passenger(Book book, String name, String surname, String fiscalcode) {
		super();
		this.book = book;
		this.name = name;
		this.surname = surname;
		this.fiscalcode = fiscalcode;
	}

	public Passenger(String name, String surname, String fiscalcode) {
		super();
		this.name = name;
		this.surname = surname;
		this.fiscalcode = fiscalcode;
	}

	public Book getBook() {
		return book;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getFiscalcode() {
		return fiscalcode;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", surname=" + surname + ", fiscalcode=" + fiscalcode + "]";
	}
	

}