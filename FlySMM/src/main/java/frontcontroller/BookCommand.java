package frontcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import booking.Book;
import sale.Flight;
import servlets.SessionFactorySingleton;

public class BookCommand extends FrontCommand {
	private static final String ERROR = "/error.jsp";
	private static final Logger LOG = Logger.getLogger(BookCommand.class);
	private static final String SERVEXC = "An error occured";
	private static final String MESSAGE = "Details: The selected Passengers Have Already A reservation for this flight";
	private static final String MSG = "message";
	boolean err = false;

	@Override
	public void dispatch() throws ServletException, IOException {
		try {
			Flight departure = (Flight) request.getSession().getAttribute("chosenDeparture");
			Flight arrival = (Flight) request.getSession().getAttribute("chosenReturn");
			ArrayList<Book> listBook = (ArrayList<Book>) request.getSession().getAttribute("listBook");
			for (Book b : listBook) {
				writeBook(b);
			}
			for (Book b : listBook) {
				updateSeat(b, departure, arrival);
			}
			forward("/success.jsp");
		} catch (Exception e) {
			err = true;
			LOG.error("An error occured", e);
		}
		if (err) {
			request.setAttribute(MSG, MESSAGE);
			forward(ERROR);
		}

	}

	public static void writeBook(Book b) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(b);
		session.getTransaction().commit();
	}

	public static void updateSeat(Book b, Flight d, Flight a) {
		int seat;
		String flightId = b.getFlightId();
		if (d.getIdFlight().equals(flightId)) {
			seat = d.getRemainingSeats() - 1;
		} else {
			seat = a.getRemainingSeats() - 1;
		}
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("UPDATE Flight set Seat_Remaining = :seat " + " WHERE Flight_ID = :flightId");

		query.setParameter("seat", seat);
		query.setParameter("flightId", flightId);

		query.executeUpdate();
		session.getTransaction().commit();

	}
}
