package promotion;

public abstract class Promotion {
	protected int discountRate;
	protected boolean fidelity;
	protected int idPromo;
	protected String name;
	
	public abstract String notify_();
}