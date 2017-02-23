package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import booking.Baggage;
import booking.Book;
import booking.Passenger;
import sale.Flight;
import servlets.SessionFactorySingleton;

public class BookCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		Flight departure = (Flight) request.getSession().getAttribute("chosenDeparture");
		Flight arrival = (Flight) request.getSession().getAttribute("chosenReturn");
		ArrayList<Book> listBook = (ArrayList<Book>) request.getSession().getAttribute("listBook");
		for (Book b : listBook) {
			writeBook(b);
		}
		for (Book b : listBook) {
			updateSeat(b, departure, arrival);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.html");
		requestDispatcher.forward(request, response);

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
		String hql = "UPDATE Flight set Seat_Remaining = " + seat + " WHERE Flight_ID = '" + flightId + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();

	}
}
