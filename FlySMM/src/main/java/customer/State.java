package customer;

public abstract class State {
	
	protected FidelityCustomer c;
	
	public State(FidelityCustomer c) {
		super();
		this.c = c;
	}


	public abstract String isFidelity();
}
