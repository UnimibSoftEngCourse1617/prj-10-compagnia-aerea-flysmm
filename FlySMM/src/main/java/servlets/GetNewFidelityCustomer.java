package servlets;

import java.io.IOException;
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
		String myObjectId = request.getParameter("myObjectId");
		Object myObject = request.getSession().getAttribute(myObjectId);
		request.getSession().removeAttribute(myObjectId);
		Customer cFidelity = new FidelityCustomer((Customer)myObject);
		
		//FidelityCustomer cFidelity = (FidelityCustomer) myObject;
		response.getWriter().append(myObject.toString());
		writeFidelityCustomer((FidelityCustomer) cFidelity);

	}

	public static void writeFidelityCustomer(FidelityCustomer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.update(c);
		session.getTransaction().commit();
	}

}
