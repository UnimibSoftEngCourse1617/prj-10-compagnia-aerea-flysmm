package sale;

import java.io.Serializable;

public class Aircraft implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAircraft;
	private String constructor;
	private long totalSize;
	private float weightBound;
	private String model;
	
	public Aircraft() {
		super();
	}

	
	public Aircraft(int idAircraft, String constructor, long totalSize, float weightBound,
			String model) {
		this.idAircraft = idAircraft;
		this.constructor = constructor;
		this.totalSize = totalSize;
		this.weightBound = weightBound;
		this.model = model;
	}

	public int getIdAircraft() {
		return idAircraft;
	}

	public void setIdAircraft(int idAircraft) {
		this.idAircraft = idAircraft;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public void setWeightBound(float weightBound) {
		this.weightBound = weightBound;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getConstructor() {
		return constructor;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public float getWeightBound() {
		return weightBound;
	}

	public String getModel() {
		return model;
	}

}
