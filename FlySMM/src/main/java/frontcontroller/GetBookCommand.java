package frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import booking.Book;
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

	public List<Book> getBookUnpayed(long id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		String query1 = "from Book where User_ID = :id1 and Payed = '0'";
		List<Book> result = session.createQuery(query1).setLong("id1", id).list();
		return result;
	}

	public List<Book> getBookPayed(long id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		String query2 = "from Book where User_ID = :id2 and Payed = '1'";
		List<Book> result = session.createQuery(query2).setLong("id2", id).list();

		return result;
	}
}
