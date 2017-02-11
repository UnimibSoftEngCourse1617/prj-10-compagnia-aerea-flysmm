package customer;

import java.time.LocalDate;

public class FidelityState extends State {
	
	private LocalDate actualDate;
	
	public FidelityState(FidelityCustomer c) {
		super(c);
	}

	public String isFidelity() {
		
		this.actualDate= LocalDate.now();
		if(c.startDate.lengthOfYear()<=365){
			return "Customer fidelity";
		} else {
			return c.setFidelity("Customer Unfidelity");
		}
		

	}

}
