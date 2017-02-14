package booking;

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
import sale.Airport;
import sale.Flight;
import sale.Passenger;

public class AppBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Date data = new Date();

	public AppBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);
		Airport a1 = new Airport("MXP", "Malpensa");
		Airport a2 = new Airport("LIN", "Linate");
		Passenger p = new Passenger("Chiara", "Ferragni", "SNUNTR777DPG");
		Passenger p1 = new Passenger("Lara", "Cambiaghi", "LRCMB1234DPG");
		Passenger p2= new Passenger("Gianluca", "Guarnieri", "AJEJEBRZ987DPG");


		Flight f = new Flight("abc1234", a1, a2);
		Book b = new Book(c, f);
		b.addPassenger(p);
		b.addPassenger(p1);
		b.addPassenger(p2);


		response.getWriter().append(b.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	}

}
