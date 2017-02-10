package customer;

public class UnfidelityCustomer extends State {

	public UnfidelityCustomer(FidelityCustomer fidelityCustomer) {
		super(fidelityCustomer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void isFidelity() {
		// TODO Auto-generated method stub
		System.out.print("utent infedele");
	}

}
