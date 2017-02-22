package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import booking.Baggage;
import booking.Book;
import booking.Passenger;
import sale.Flight;
import servlets.SessionFactorySingleton;

public class GetBookCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {

		long idCustomer = (Long) request.getSession().getAttribute("idCustomer");
		float totalPrice = 0;
		List<Book> bUnpayed = getBookUnpayed(idCustomer);
		request.setAttribute("listBookUnpayed", bUnpayed);
		request.setAttribute("listBookPayed", getBookPayed(idCustomer));
		
		for (Book b : bUnpayed) {
			totalPrice += b.getTotalPrice();
		}
		request.setAttribute("totalPriceHomeCustomer", totalPrice);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/allBook.jsp");

		requestDispatcher.forward(request, response);
	}

	public List getBookUnpayed(long id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		List result = session.createQuery("from Book where User_ID = '" + id + "' and Payed = '0'").list();
		System.out.println(result);
		return result;
	}

	public List getBookPayed(long id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		List result = session.createQuery("from Book where User_ID = '" + id + "' and Payed = '1'").list();
		
		return result;
	}
}
