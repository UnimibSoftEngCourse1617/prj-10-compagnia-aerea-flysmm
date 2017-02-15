package booking;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import sale.Airport;
import sale.Flight;
import booking.Passenger;

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
		Flight f1 = new Flight("abc1234", a1, a2);
		Flight f2 = new Flight("abc1234", a2, a1);
		Book b = new Book(c, f1, f2);
		Passenger p = new Passenger("Chiara", "Ferragni", "SNUNTR777DPG");
		Passenger p1 = new Passenger("Lara", "Cambiaghi", "LRCMB1234DPG");
		Passenger p2 = new Passenger("Gianluca", "Guarnieri", "AJEJEBRZ987DPG");
		Baggage v = new Baggage(b, p, 10);
		Baggage v1 = new Baggage(b, p1, 10);

		b.addPassenger(p);
		b.addPassenger(p1);
		b.addPassenger(p2);
		b.addBaggage(v);
		b.addBaggage(v1);
		response.getWriter().append(b.toString());
		System.out.println(b.isExpired());

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
