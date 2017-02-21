package sale;

import java.io.Serializable;

public class Seat implements Serializable {

	private int row;
	private String seat;
	private String tariff;
	private Aircraft aircraft;

	public Seat() {
		super();
	}

	public Seat(int row, String seat, String tariff, Aircraft aircraft) {
		super();
		this.row = row;
		this.seat = seat;
		this.tariff = tariff;
		this.aircraft = aircraft;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

}