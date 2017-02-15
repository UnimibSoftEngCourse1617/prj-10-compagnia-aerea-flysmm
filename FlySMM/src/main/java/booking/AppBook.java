
package booking;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

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
import sale.Aircraft;
import sale.Airport;
import sale.Flight;
import booking.Passenger;
import servlets.SessionFactorySingleton;

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
		Flight f = new Flight("abc1234", a1, a2);
		Book b = new Book(c, f);

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
		System.out.println(b.toString());
		response.getWriter().append(b.toString());
		Aircraft a11 = new Aircraft(new Flight(), 1, "Airbus", 387, 3, "A380");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void writeAircraft(Aircraft a) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(a);
		session.getTransaction().commit();
	}

}
