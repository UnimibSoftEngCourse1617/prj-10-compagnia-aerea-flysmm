package customer;

public class UnfidelityState extends State {

	public UnfidelityState(FidelityCustomer c) {
		super(c);

	}

	@Override
	public String isFidelity() {

		String status = "Cuatomer Unfidelity";
		return status;
	}

}
