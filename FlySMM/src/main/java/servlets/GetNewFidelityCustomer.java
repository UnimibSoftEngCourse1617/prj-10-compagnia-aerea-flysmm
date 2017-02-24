package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Query;

import org.apache.log4j.Logger;

import org.hibernate.Session;

import booking.Book;
import customer.Customer;
import customer.FidelityCustomer;

/**
 * Servlet implementation class GetNewFidelityCustomer
 */
@WebServlet("/GetNewFidelityCustomer")
public class GetNewFidelityCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(GetNewFidelityCustomer.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetNewFidelityCustomer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object myObject = request.getSession().getAttribute("customer");

		FidelityCustomer cFidelity = new FidelityCustomer((Customer) myObject);

		response.getWriter().append(cFidelity.toString());

		request.getSession().setAttribute("customer", cFidelity);
		// scrivo e poi cancello perchè hibernate non permette l'update del
		// discriminatore
		
		writeFidelityCustomer((FidelityCustomer) cFidelity);
		//qua inserire delete Book
		
		Customer customerDelete = (Customer)myObject;
		
		List<Book> b = getBookCustomer(customerDelete.getIdCustomer());
		System.out.println(b+" aaa ");
		System.out.println(b);
		deleteBook(customerDelete.getIdCustomer());
		
		for (Book newBook : b) {
			newBook.setCustomerId(cFidelity.getIdCustomer());
			writeBook(newBook);
		}
		
		deleteCustomer((Customer) myObject);
		request.getSession().setAttribute("Customer", cFidelity);

		request.getSession().setAttribute("idCustomer", cFidelity.getIdCustomer());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeFidelityCustomer.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
	}

	private List<Book> getBookCustomer(long idCustomer) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Book WHERE User_ID = :userId");
		query.setParameter("userId", idCustomer);
		System.out.println(query);
		List<Book> temp = (List<Book>) query.list();
		System.out.println(query.list()+" bbb ");
		session.getTransaction().commit();
		return temp;
	}
	public static void writeBook(Book b) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(b);
		session.getTransaction().commit();
	}

	private void deleteCustomer(Customer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.delete(c);
		session.getTransaction().commit();
		
	}

	public void writeFidelityCustomer(FidelityCustomer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
	}
	public static void deleteBook(long idCustomer) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("delete from Book WHERE User_ID = :userId");
		query.setParameter("userId", idCustomer);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
