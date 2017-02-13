package sale;

import java.util.TimeZone;

public class Address {
	private String city;
	private String country;
	private TimeZone timezone;
	
	public Address(String city, String country, TimeZone timezone) {
		super();
		this.city = city;
		this.country = country;
		this.timezone = timezone;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public TimeZone getTimezone() {
		return timezone;
	}
}
