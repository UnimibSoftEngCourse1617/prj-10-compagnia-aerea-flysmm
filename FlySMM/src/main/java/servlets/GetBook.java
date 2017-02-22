package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import booking.Baggage;
import booking.Passenger;

public class GetBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBook() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long idCustomer = (Long) request.getSession().getAttribute("idCustomer");
		System.out.println(idCustomer);
		getBookUnpayed(idCustomer);

	}

	public List getBookUnpayed(long id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		org.hibernate.Query query =  session.createQuery(
				"FROM Book " +
				"WHERE User_ID = ? " +
				"AND Payed = '0'"
				);
		query = query.setParameter(0, id);
		List result = query.list();
		
		return result;
	}

}
