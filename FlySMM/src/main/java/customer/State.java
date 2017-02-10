package customer;

public abstract class State {
	
	protected FidelityCustomer fidelityCustomer;

	public State(FidelityCustomer fidelityCustomer) {
		super();
		this.fidelityCustomer = fidelityCustomer;
	}

	

	public abstract void isFidelity();
}
