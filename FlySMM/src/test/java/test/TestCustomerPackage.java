package test;

import java.util.Date;

import org.junit.Test;


import customer.Customer;
import customer.FidelityCustomer;
import junit.framework.TestCase;
import sale.Address;


public class TestCustomerPackage extends TestCase {
	Date date = new Date();
	
	Address address = new Address(1, "via Roma", "12", "200841", "Carate Brianza", "Italy");
	Customer customer = new Customer(1, "Mario", "Rossi", address, "mario.rossi@gmail.com", "1234", "3331234567", date);
	FidelityCustomer cFidelity = new FidelityCustomer(customer);
	
	@Test
	public void testFidelityCustomer() {
		assertEquals("Fidelity Customer",this.cFidelity.getType());
		assertEquals(0,this.cFidelity.getPoint());
	}

}
