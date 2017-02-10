package customer;

public class FidelityState extends State {

	public FidelityState(FidelityCustomer fidelityCustomer) {
		super(fidelityCustomer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void isFidelity() {
		// TODO Auto-generated method stub
		
		System.out.print("utente fedele");
	}

}
