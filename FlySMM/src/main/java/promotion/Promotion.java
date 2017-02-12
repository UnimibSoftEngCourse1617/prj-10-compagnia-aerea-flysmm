package promotion;

public abstract class Promotion {
	private int discountRate;
	private boolean fidelity;
	private int idPromo;
	private String name;
	
	public abstract String notify_();
}