package customer;

public abstract class State {
	

	protected FidelityCustomer c;
	
	public State(FidelityCustomer c) {
		this.c = c;
	}


	public abstract void changeFidelity();
}
