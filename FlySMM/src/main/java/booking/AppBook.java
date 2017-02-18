
package booking;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
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
import sale.Price;
import booking.Passenger;
import servlets.SessionFactorySingleton;

public class AppBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Date data = new Date();
	private Time time = new Time(8,0,0);
	private Price price = new Price();
	
	public AppBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);
		Airport a1 = new Airport("MXP", "Malpensa");
		Airport a2 = new Airport("LIN", "Linate");
		Aircraft acf = new Aircraft(77654, "Boeing", 1000, 2737, "737");
		Flight f = new Flight(acf, time, time, "abc1", data, a1, data, a2, price);
		Flight f1 = new Flight(acf, time, time, "abc2", data, a1, data, a2, price);


		// Flight f = new Flight("abc1", a1, a2);
		// Flight f1 = new Flight("abc2", a1, a2);

		Passenger p = new Passenger("ABC123", "Chiara", "Ferragni", data, "donna", "Sport");
		writePassenger(p);
		Book b = new Book(c, f, p);
		writeBook(b);

		
		Passenger p1 = new Passenger("DEF456", "Lara", "Cambiaghi", data, "donna", "Personal");
		Book b1 = new Book(c, f1, p1);
		writePassenger(p1);

		// writeBook(b1);

		Passenger p2 = new Passenger("GHI789", "Gianluca", "Guarnieri", data, "uomo", "Sport");
		writePassenger(p2);

		Book b2 = new Book(c, f, p2);
		// writeBook(b2);
		response.getWriter().append(b.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void writePassenger(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}

	public static void writeBaggage(Baggage v) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(v);
		session.getTransaction().commit();
	}

	public static void writeBook(Book b) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(b);
		session.getTransaction().commit();

	}

}
