package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import customer.Customer;
import sale.Flight;
import servlets.HibernateProxyTypeAdapter;
import servlets.SessionFactorySingleton;

public class CustomerCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getCustomerFromDb();
		}
	}

	public void getCustomerFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		Customer customerRegistry = null;
		try {
			List result = session.createQuery("from Customer " + "where email = '" + request.getParameter("email") + "'"
					+ " and password = '" + request.getParameter("psw") + "'").list();
			if (result.get(0) != null) {
				customerRegistry = (Customer) result.get(0);
				RequestDispatcher dispatcher = context.getRequestDispatcher("/homeCustomer.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = context.getRequestDispatcher("./loginPage.html");
				dispatcher.forward(request, response);
			}

			System.out.println(customerRegistry.toString());
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
