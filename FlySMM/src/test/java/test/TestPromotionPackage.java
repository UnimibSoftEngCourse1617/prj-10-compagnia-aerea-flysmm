package test;


import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;

import org.junit.Test;
import org.apache.log4j.Logger;
import javax.mail.MessagingException;

import junit.framework.TestCase;
import promotion.*;
import sale.Address;
import sale.Aircraft;
import sale.Airport;
import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;
import java.util.Date;
import java.util.List;

public class TestPromotionPackage extends TestCase{
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(TestPromotionPackage.class);
	
	Date date = new Date();
	Time time = new Time(0);
	Address address = new Address(1, "via Roma", "12", "200841", "Carate Brianza", "Italy");
	Aircraft aircraft = new Aircraft(1, "Boeing", 85, 1234, "737");
	Airport airport = new Airport("MXP", "Malpensa", address);
	Price price = new Price(77);
	Flight flight = new Flight(aircraft, time, time, "mh51", date, airport, date, airport, price, 45);

	@Test
	public void testSeasonPromotion() throws MessagingException {
		SeasonPromotion p1 = new SeasonPromotion("1", 40, true, "Autumn Promo", "ungaretti", new Date(), new Date());
		assertEquals("season", p1.getPromoType());
	}
	
	@Test
	public void testFlightPromotion() throws ServletException, IOException{
		org.hibernate.Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		String query1 = "from Flight where Flight_ID = :id";
		@SuppressWarnings("unchecked")
		List<Flight> result = session
				.createQuery(query1)
				.setString("id", flight.getIdFlight())
				.list();
		
		Flight f = result.get(0);
		FlightPromotion p2 = null;
		try {
			p2 = new FlightPromotion("11", 35, false, "Boieng 777 Promo", "w le yeezy", f);
		} catch (MessagingException e) {
			LOG.info(SERVEXC, e);
		}
		assertEquals("mh51", p2.getFlight().getIdFlight());
		assertEquals("flight", p2.getPromoType());
	}
}
