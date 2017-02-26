package booking;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;

public class Passenger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Fiscal_code;
	private String name;
	private String surname;
	private String documentCode;
	private String documentType;
	private Date Birth_date;
	private String baggageId;

	public Passenger() {
		super();
	}

	public Passenger(String fiscal_code, String name, String surname, String documentCode, String documentType,
			Date birth_date, String baggageId) {
		super();
		Fiscal_code = fiscal_code;
		this.name = name;
		this.surname = surname;
		this.documentCode = documentCode;
		this.documentType = documentType;
		Birth_date = birth_date;
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

	public String getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(String baggageId) {
		this.baggageId = baggageId;
	}

	public String getDocumentCode() {
		return documentCode;
	}

	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	@Override
	public String toString() {
		return "Passenger [Fiscal_code=" + Fiscal_code + ", name=" + name + ", surname=" + surname + ", documentCode="
				+ documentCode + ", documentType=" + documentType + ", Birth_date=" + Birth_date + ", baggageId="
				+ baggageId + "]";
	}

}