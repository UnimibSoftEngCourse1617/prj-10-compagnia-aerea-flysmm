package frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import customer.Customer;
import servlets.SessionFactorySingleton;

public class DeleteBookCommand extends FrontCommand {
	

	@Override
	public void dispatch() throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		Customer customer = (Customer) request.getSession().getAttribute("Customer");
		this.deleteBook( (String) request.getAttribute("deleteBookId") );
		if (customer.getClass().toString().matches("class customer.FidelityCustomer")) {
			requestDispatcher = request.getRequestDispatcher("/homeFidelityCustomer.jsp");
		} else {
			requestDispatcher = request.getRequestDispatcher("/homeCustomer.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	public void deleteBook(String bookId) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("delete from Book WHERE IdBook = :bookId");
		query.setParameter("bookId", bookId);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
