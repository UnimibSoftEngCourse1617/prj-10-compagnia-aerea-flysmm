package test;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.apache.log4j.Logger;
import javax.mail.MessagingException;

import junit.framework.TestCase;
import promotion.*;
import sale.Flight;
import servlets.SessionFactorySingleton;
import java.util.Date;
import java.util.List;

public class TestPromotionPackage extends TestCase{
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(TestPromotionPackage.class);
	
	Flight flight =  new Flight();
	@Test
	public void testSeasonPromotion() throws MessagingException {
		SeasonPromotion p1 = new SeasonPromotion("1", 40, true, "Autumn Promo", "ungaretti", new Date(), new Date());
		assertEquals("season", p1.getPromoType());
	}
	
	@Test
	public void testFlightPromotion() throws ServletException, IOException{
		org.hibernate.Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		flight.setIdFlight("lorem");
		String query1 = "from Flight where Flight_ID = :id";
		@SuppressWarnings("unchecked")
		List<Flight> result = session
				.createQuery(query1)
				.setString("id", flight.getIdFlight())
				.list();
		
		Flight f = result.get(0);
		FlightPromotion p2 = null;
		try {
			p2 = new FlightPromotion("6", 35, true, "Boieng 777 Promo", "w le yeezy", f);
		} catch (MessagingException e) {
			LOG.info(SERVEXC, e);
		}
		assertEquals("flight", p2.getPromoType());
	}
}
