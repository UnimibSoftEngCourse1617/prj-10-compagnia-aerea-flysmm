package booking;

import java.util.Date;

import javax.persistence.GeneratedValue;

public class Passenger {
	@GeneratedValue
	private String Fiscal_code;
	private String name;
	private String surname;
	private Date Birth_date;
	private String type;
	private String baggageId;

	public Passenger() {
		super();
	}

	
	public Passenger(String fiscal_code, String name, String surname, Date birth_date, String type, String baggageId) {
		super();
		Fiscal_code = fiscal_code;
		this.name = name;
		this.surname = surname;
		Birth_date = birth_date;
		this.type = type;
		this.baggageId = baggageId;
	}

	public String getFiscal_code() {
		return Fiscal_code;
	}

	public void setFiscal_code(String fiscal_code) {
		Fiscal_code = fiscal_code;
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

	public Date getBirth_date() {
		return Birth_date;
	}

	public void setBirth_date(Date birth_date) {
		Birth_date = birth_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(String baggageId) {
		this.baggageId = baggageId;
	}

	@Override
	public String toString() {
		return "Passenger [Fiscal_code=" + Fiscal_code + ", name=" + name + ", surname=" + surname + ", Birth_date="
				+ Birth_date + ", type=" + type + ", baggageId=" + baggageId + "]";
	}

}