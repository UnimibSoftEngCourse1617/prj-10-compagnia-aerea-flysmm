package promotion;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import customer.Customer;

/**
 * Servlet implementation class App
 */
public class AppPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Date data = new Date();
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
		Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);
		Customer c1 = new Customer(122, "luca1", "lorusso", "dgs", "dgvs", "popo", data);
		Customer c2 = new Customer(123, "luca2", "lorusso", "dgs", "dgvs", "popo", data);
		Customer c3 = new Customer(124, "luca3", "lorusso", "dgs", "dgvs", "popo", data);
		
		SeasonPromotion p = new SeasonPromotion(50, true, 123, "Dpg Promo", data,data);
		SeasonPromotion p1 = new SeasonPromotion(50, true, 124, "Dpg Promo", data,data);
		FlightPromotion p2 = new FlightPromotion(50, false, 125, "Dpg Promo", 1234);
		FlightPromotion p3 = new FlightPromotion(50, true, 126, "Dpg Promo", 1235);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
