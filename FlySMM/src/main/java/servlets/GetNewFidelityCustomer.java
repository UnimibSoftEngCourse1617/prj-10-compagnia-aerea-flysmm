package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

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
		deleteCustomer((Customer) myObject);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeFidelityCustomer.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
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

}
