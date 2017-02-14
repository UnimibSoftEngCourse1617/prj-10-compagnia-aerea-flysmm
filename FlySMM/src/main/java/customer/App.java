package customer;

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
import customer.FidelityCustomer;
import customer.FidelityState;

/**
 * Servlet implementation class App
 */
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Date data = new Date();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.getRequestDispatcher("/webapp/index.jsp").forward(request, response);
//		configureUsingHibernateConfigXMLFile();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);
		FidelityCustomer c2 = new FidelityCustomer(c);
		//response.getWriter().append(c.toString()).append(request.getContextPath());
		response.getWriter().append(c2.toString()).append(request.getContextPath()).append(c2.getState().toString());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void configureUsingHibernateConfigXMLFile() {
		// Create configuration instance
		Configuration configuration = new Configuration();
		// Pass hibernate configuration file
		configuration.configure("hibernate.cfg.xml");

		// Since version 4.x, service registry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Create session factory instance
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		// Get current session
		Session session = factory.getCurrentSession();

		// Begin transaction
		session.getTransaction().begin();

		// Print out all required information
		System.out.println("Session Is Opened :: " + session.isOpen());
		System.out.println("Session Is Connected :: " + session.isConnected());

		// // Create message object
		// Message message = new Message();
		// message.setMessage("Hello World!");
		//
		// // Save
		// session.save(message);
		//
		// // Commit transaction
		// session.getTransaction().commit();
		//
		// System.exit(0);
	}

}
