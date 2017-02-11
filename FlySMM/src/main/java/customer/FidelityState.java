package customer;

public class FidelityState extends State {

	public FidelityState(FidelityCustomer c) {
		super(c);
		System.out.print("Utente fedele");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void isFidelity() {
		// TODO Auto-generated method stub

		// in questo metodo devo inserire quando passa da fidelity ad unfidelity
		// e se passa creo un oggetto unfidelityCustomer
		System.out.print("utente fedele");
	}

}
