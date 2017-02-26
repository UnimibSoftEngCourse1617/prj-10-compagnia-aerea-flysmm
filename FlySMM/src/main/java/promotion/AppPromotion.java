package promotion;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import promotion.SeasonPromotion;
import sale.Flight;
import servlets.SessionFactorySingleton;
import promotion.FlightPromotion;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class App
 */
public class AppPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(AppPromotion.class);
       
    public AppPromotion() {
        super();
    }

     @Override
   //Quando voglio aggiungere una mail mi basta togliere i commenti, gli utenti veranno automaticamente avvisati
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SeasonPromotion p1 = null;
    	  SeasonPromotion p2 = null;
    	  SeasonPromotion p3 = null;
    	  SeasonPromotion p4 = null;
    	  SeasonPromotion p5 = null;
		try {
			p1 = new SeasonPromotion("1", 40, true, "Carnival Promo", "40% Offer! Enjoy your Carnival!", new Date(), new Date());
			p2 = new SeasonPromotion("2", 50, true, "Autumn Promo", "Leaf fall? You Fly! Enjoy our 50% Offer!", new Date(), new Date());
			p3 = new SeasonPromotion("3", 30, false, "Spring Promo", "In this season you can fly with 30", new Date(), new Date());
			p4 = new SeasonPromotion("4", 30, true, "Summer Promo", "It's time to flight! You have an 30% Offer only for you!", new Date(), new Date());
			p5 = new SeasonPromotion("5", 20, false, "Winter Promo", "Too cold? Flight to a hot destination, enjoy our 20% Offer!", new Date(), new Date());
		} catch (MessagingException e) {
			LOG.info(SERVEXC, e);
		}
		/*
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		String query1 = "from Flight where Flight_ID = :id";
		@SuppressWarnings("unchecked")
		List<Flight> result = session
				.createQuery(query1)
				.setString("id", "mh51")
				.list();
		
		Flight f = result.get(0);
				
		FlightPromotion p2 = null;
		try {
			p2 = new FlightPromotion("2", 35, false, "Boieng 777 Promo", "w le yeezy",
								 f);
		} catch (MessagingException e) {
			LOG.info(SERVEXC, e);
		}*/
		writeSeasonPromotion(p1);
		//writeFlightPromotion(p2);
		
		response.getWriter().append(p1.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Empty because useless at the moment
	}
	
	public static void writeSeasonPromotion(SeasonPromotion p) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	
	public static void writeFlightPromotion(FlightPromotion p) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
}
