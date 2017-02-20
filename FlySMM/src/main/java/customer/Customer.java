package customer;

import java.util.Date;

import sale.Address;

public class Customer {

	private long idCustomer;
	private String name;
	private String surname;
	private Address address;
	private String email;
	private String password;
	private String phoneNumber;
	private Date dateOfBirth;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	public Customer(long idCustomer, String name, String surname, Address address, String email, String password,
			String phoneNumber, Date dateOfBirth) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public Customer(FidelityCustomer fidelityCustomer) {
		this.idCustomer = fidelityCustomer.getIdCustomer();
		this.name = fidelityCustomer.getName();
		this.surname = fidelityCustomer.getSurname();
		this.email = fidelityCustomer.getEmail();
		this.password = fidelityCustomer.getPassword();
		this.phoneNumber = fidelityCustomer.getPhoneNumber();
		this.dateOfBirth = fidelityCustomer.getDateOfBirth();
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long l) {
		this.idCustomer = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
	

}
