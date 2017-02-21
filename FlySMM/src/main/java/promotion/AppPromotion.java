package promotion;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import promotion.SeasonPromotion;
import sale.*;
import servlets.SessionFactorySingleton;
import promotion.FlightPromotion;
import java.util.Date;

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
		SeasonPromotion p1 = new SeasonPromotion("1", 40, false, "Winter Promo", "Brrr", new Date(), new Date());
		//FlightPromotion p2 = new FlightPromotion("2", 30, true, "Air Force 2 Promo", "Obama > Trump",
		//					 new Flight(new Aircraft(), new Time(0), new Time(1), "idf", new Date(), new Airport(), new Date(), new Airport(), new Price()));
		writeSeasonPromotion(p1);
		//writeFlightPromotion(p2);
		response.getWriter().append(p1.toString());
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
	}
}
