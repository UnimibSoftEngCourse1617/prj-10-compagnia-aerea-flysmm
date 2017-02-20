package frontController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class NewCustomerCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
//			String id = request.getParameter("id");
//			long pollo = Long.valueOf(id).longValue();
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			
			String psw = request.getParameter("password");
			String tel = request.getParameter("phoneNumber");
			String dataN = request.getParameter("dateOfBirth");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			try {
				startDate = sdf.parse(dataN);
				Customer c = new Customer(1, name, surname,address, email, psw, tel, startDate);
				writeCustomer(c);
				RequestDispatcher dispatcher = context.getRequestDispatcher("/loginPage.html");
				dispatcher.forward(request, response);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void writeCustomer(Customer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
	}

}