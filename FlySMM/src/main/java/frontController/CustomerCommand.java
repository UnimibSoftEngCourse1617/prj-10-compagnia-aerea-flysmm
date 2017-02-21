package frontController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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
			if (result.size() == 1) {
				customerRegistry = (Customer) result.get(0);
				String myObjectId = UUID.randomUUID().toString();
				request.getSession().setAttribute(myObjectId, customerRegistry);
				request.setAttribute("myObjectId", myObjectId);
				request.getSession().setAttribute("idCustomer", customerRegistry.getIdCustomer());
				request.getSession().setAttribute("Customer", customerRegistry);
				RequestDispatcher dispatcher;
				if (request.getSession().getAttribute("chosenDeparture") == null)
					dispatcher = context.getRequestDispatcher("/homeCustomer.jsp");
				else
					dispatcher = context.getRequestDispatcher("/addPassenger.jsp");
				dispatcher.forward(request, response);
				System.out.println(customerRegistry.toString());
			} else {
				RequestDispatcher dispatcher = context.getRequestDispatcher("/loginPage.html");
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(dialog, "The email or password are wrong! Retry!");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
