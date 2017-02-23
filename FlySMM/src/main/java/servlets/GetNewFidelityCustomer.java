package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import customer.Customer;
import customer.FidelityCustomer;
import sale.Address;

/**
 * Servlet implementation class GetNewFidelityCustomer
 */
@WebServlet("/GetNewFidelityCustomer")
public class GetNewFidelityCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetNewFidelityCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		Object myObject = request.getSession().getAttribute("customer");

		FidelityCustomer cFidelity = new FidelityCustomer((Customer) myObject);

		response.getWriter().append(cFidelity.toString());

		System.out.println(cFidelity.getClass().toString());
		request.getSession().setAttribute("customer", cFidelity);
		// scrivo e poi cancello perchè hibernate non permette l'update del
		// discriminatore
		writeFidelityCustomer((FidelityCustomer) cFidelity);
		deleteCustomer((Customer) myObject);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeFidelityCustomer.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
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
