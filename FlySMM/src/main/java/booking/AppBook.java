
package booking;

import java.io.IOException;
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
		Flight f = new Flight("abc1", a1, a2);
		Flight f1 = new Flight("abc2", a1, a2);

		Book b = new Book();

		Passenger p = new Passenger("Chiara", "Ferragni");
		Passenger p1 = new Passenger("Lara", "Cambiaghi");
		Passenger p2 = new Passenger("Gianluca", "Guarnieri");
		Baggage v = new Baggage(10, 8, 58, b.getCustomerId(), "abc1");
		Baggage v1 = new Baggage(10, 9, 59, b.getCustomerId(), "abc1");
		System.out.println(v.toString());
		b.addPassenger(p);
		writePassenger(p);

		b.addPassenger(p1);
		writePassenger(p1);

		b.addPassenger(p2);
		writePassenger(p2);

		b.addBaggage(v);
		writeBaggage(v);

		b.addBaggage(v1);
		writeBaggage(v1);

		response.getWriter().append(b.toString());
		Aircraft a11 = new Aircraft(new Flight(), 1, "Airbus", 387, 3, "A380");
		writeBook(b);

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
		for (Book book : getListBook(b)) {
			Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			session.save(book);
			session.getTransaction().commit();
		}
	}

	public static ArrayList<Book> getListBook(Book b) {
		ArrayList<Book> listBook = new ArrayList<Book>();

		for (Flight flight : b.getListFlight()) {
			for (Passenger passenger : b.getListPassenger()) {
				Book tmp = new Book(b.getCustomerId(), flight);
				tmp.setFlightId(flight.getIdFlight());
				tmp.setDocumentP(passenger.getDocument());
				listBook.add(tmp);

			}
		}
		return listBook;

	}

}
