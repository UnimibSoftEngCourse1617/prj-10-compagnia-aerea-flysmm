package Test;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import booking.Book;
import booking.Passenger;
import customer.Customer;
import junit.framework.TestCase;
import sale.Address;
import sale.Aircraft;
import sale.Airport;
import sale.Flight;
import sale.Price;

public class TestBookPackage extends TestCase {
	Date date = new Date();
	Time time = new Time(0, 0, 0);
	Address address = new Address(1, "via Roma", "12", "200841", "Carate Brianza", "Italy");
	Customer customer = new Customer(1, "Mario", "Rossi", address, "mario.rossi@gmail.com", "1234", "3331234567", date);
	Aircraft aircraft = new Aircraft(1, "Boeing", 85, 1234, "737");
	Airport airport = new Airport("MXP", "Malpensa", address);
	Price price = new Price(77);
	Flight flight = new Flight(aircraft, time, time, "MAL123", date, airport, date, airport, price, 45);
	Passenger passenger = new Passenger("LRCMB123ABC", "Lara", "Cambiaghi", "AR123ABC", "IdentityCard", date, "Sport");

	@Test
	public void testCreateBookId() {
		price.setFlight(flight);
		Book book = new Book(customer, flight, passenger);
		assertEquals("MXPMXPMAL1231LRCMB123ABC", book.createBookId(flight, customer, passenger));
	}
}
