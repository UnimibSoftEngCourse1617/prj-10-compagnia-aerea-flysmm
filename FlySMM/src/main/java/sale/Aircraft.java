package sale;

public class Aircraft {

	private Flight flight;
	private String idAircraft;
	private String constructor;
	private int totalSize;
	private float weightBound;
	private String model;

	public Aircraft(Flight flight, String idAircraft, String constructor, int totalSize, float weightBound,
			String model) {
		this.flight = flight;
		this.idAircraft = idAircraft;
		this.constructor = constructor;
		this.totalSize = totalSize;
		this.weightBound = weightBound;
		this.model = model;
	}
	
	public Flight getFlight() {
		return flight;
	}

	public String getIdAircraft() {
		return idAircraft;
	}

	public String getConstructor() {
		return constructor;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public float getWeightBound() {
		return weightBound;
	}

	public String getModel() {
		return model;
	}

}
