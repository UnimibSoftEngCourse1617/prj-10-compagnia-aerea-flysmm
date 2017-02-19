
package customer;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import customer.Customer;
import customer.FidelityCustomer;
import customer.FidelityState;

import servlets.SessionFactorySingleton;

public class AppCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Date data = new Date();

	public AppCustomer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer c = new Customer(112121, "luca", "lorusso", "luca@lorusso", "pollo", "popo", data);
		FidelityCustomer c2 = new FidelityCustomer(1641, "paolo", "dfibvi", "drgvegs", "dgwrfwfvs", "poefrepo", data);
		writeCustomer(c);
		writeCustomer(c2);
		response.getWriter().append(c.toString()).append(String.valueOf(c.getDateOfBirth()));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void writeCustomer(Customer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
	}

}