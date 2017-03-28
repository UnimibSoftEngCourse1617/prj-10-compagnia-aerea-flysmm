package test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import junit.framework.TestCase;
import sale.Aircraft;
import sale.Airport;
import sale.Flight;
import sale.Price;
import sale.Seat;
import servlets.GetReturnFlight;

public class TestSale extends TestCase {

	Seat s1 = new Seat(1, "A", "base", new Aircraft());
	Seat s2 = new Seat(1, "B", "base", new Aircraft());
	Seat s3 = new Seat(1, "C", "base", new Aircraft());
	Seat s4 = new Seat(2, "A", "premium", new Aircraft());
	Seat s5 = new Seat(2, "B", "premium", new Aircraft());
	Seat s6 = new Seat(2, "C", "premium", new Aircraft());

	Flight f = new Flight(new Aircraft(), new Time(0), new Time(0), "mh51", new Date(0), new Airport(), new Date(0),
			new Airport(), null, 40);

	Price p1 = new Price(f, s1, null, 50);
	Price p2 = new Price(f, s4, null, 40);
	
	Flight f1 = new Flight(f,p1);
	Flight f2 = new Flight(f,p2);
	
	List<Flight> flights = new ArrayList<Flight>();
	
	@Test
	public void testFindFlightFromIdAndTariff() {
		flights.add(f1);
		flights.add(f2);
		assertEquals(f1,GetReturnFlight.findFlightFromIdAndTariff(flights,"mh51","base"));
		assertEquals(f2,GetReturnFlight.findFlightFromIdAndTariff(flights,"mh51","premium"));
		assertEquals(null,GetReturnFlight.findFlightFromIdAndTariff(flights,"mh3532","base"));
		assertEquals(null,GetReturnFlight.findFlightFromIdAndTariff(flights,"mh51","business"));
	}
}
