package promotion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import promotion.SeasonPromotion;
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
		configureUsingHibernateConfigXMLFile();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SeasonPromotion p1 = new SeasonPromotion(123, 50, true, "Winter Promo", "loremipsum", new Date(), new Date());
		FlightPromotion p2 = new FlightPromotion(124, 30, false, "boeing 77 Promo", "lorem_ipsum", 123);
		writeSeasonPromotion(p1);
		writeFlightPromotion(p2);
		response.getWriter().append(p1.toString()).append(p2.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void writeSeasonPromotion(SeasonPromotion p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}
	
	public static void writeFlightPromotion(FlightPromotion p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}

	public static void configureUsingHibernateConfigXMLFile(){
		// Create configuration instance
		Configuration configuration = new Configuration();
		// Pass hibernate configuration file
		configuration.configure("hibernate.cfg.xml");

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();	

		// Create session factory instance
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		// Get current session
		Session session = factory.getCurrentSession();

		// Begin transaction
		session.getTransaction().begin();

		// Print out all required information
		System.out.println("Session Is Opened :: "+session.isOpen());
		System.out.println("Session Is Connected :: "+session.isConnected());	

		/* Create message object
		Message message = new Message();
		message.setMessage("Hello World!");

		// Save
		session.save(message);*/

		// Commit transaction
		session.getTransaction().commit();

		System.exit(0);
	}
}
