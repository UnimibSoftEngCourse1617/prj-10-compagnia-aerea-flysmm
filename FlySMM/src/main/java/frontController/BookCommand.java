package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import booking.Baggage;
import booking.Book;
import booking.Passenger;
import servlets.SessionFactorySingleton;

public class BookCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		// Book b = (Book) request.getSession().getAttribute("Book");
		Book b = (Book) request.getSession().getAttribute("book");
		System.out.println(b.toString());
		writeBook(b);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.html");
		requestDispatcher.forward(request, response);

	}

	public static void writeBook(Book b) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(b);
		session.getTransaction().commit();

	}
}
