package customer;

public class UnfidelityState extends State {



	public UnfidelityState(FidelityCustomer c) {
		super(c);
		System.out.print("Utente infedele");
	}

	@Override
	public void isFidelity() {
		// TODO Auto-generated method stub
		System.out.print("utent infedele");
		
	}

}
