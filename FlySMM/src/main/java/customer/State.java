package customer;

public abstract class State {
	

	protected Customer c;
	
	public State(Customer c) {
		this.c = c;
	}


	public abstract void changeFidelity();
}
