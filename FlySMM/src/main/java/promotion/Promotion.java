package promotion;

import java.io.Serializable;

public abstract class Promotion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int discountRate;
	protected boolean fidelity;
	protected String idPromo;
	protected String name;
	protected String description;
	protected String promoType;
	
	public abstract void notify_();
	
	public Promotion(){
		super();
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public boolean isFidelity() {
		return fidelity;
	}

	public void setFidelity(boolean fidelity) {
		this.fidelity = fidelity;
	}

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}
}