package sale;

public class Address {
	private long idAddress;
	private String street;
	private String street_number;
	private int cap;
	private String city;
	private String country;
	
	public Address(){
		
	}

	public Address(long idAddress, String street, String street_number, int cap, String city, String country) {
		super();
		this.idAddress = idAddress;
		this.street = street;
		this.street_number = street_number;
		this.cap = cap;
		this.city = city;
		this.country = country;
	}

	public long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}