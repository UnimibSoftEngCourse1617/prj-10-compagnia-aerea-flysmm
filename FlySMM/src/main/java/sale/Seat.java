package sale;

public class Seat {

	private int row;
	private char seat;
	private String tariff;
	private Aircraft aircraft;

	public Seat() {
	}

	public Seat(int row, char seat, String tariff, Aircraft aircraft) {
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

	public char getSeat() {
		return seat;
	}

	public void setSeat(char seat) {
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