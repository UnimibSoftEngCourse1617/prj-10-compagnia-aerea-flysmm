package promotion;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppPromotion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*SeasonPromotion p1 = null;
		try {
			p1 = new SeasonPromotion("1", 40, true, "winter Promo", "brrr", new Date(), new Date());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Flight> result = session
				.createQuery("from Flight where Flight_ID = 'mh51'")
				.list();
		
		Flight f = result.get(0);
				
		FlightPromotion p2 = null;
		try {
			p2 = new FlightPromotion("2", 35, false, "Boieng 777 Promo", "w le yeezy",
								 f);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		writeSeasonPromotion(p1);
		writeFlightPromotion(p2);
		
		response.getWriter().append(p1.toString()).append(p2.toString());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		System.out.println(p);
	}
}
