package frontController;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import booking.Book;
import booking.Passenger;
import customer.Customer;
import sale.Aircraft;
import sale.Airport;
import sale.Flight;
import sale.Price;
import servlets.HibernateProxyTypeAdapter;
import servlets.SessionFactorySingleton;

public class AddPassengerCommand extends FrontCommand {

	private Date data = new Date();
	//Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			HttpSession session = request.getSession();
			ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();

			String nPass = (String) request.getSession().getAttribute("passengers");
			int length = Integer.parseInt(nPass);
			for (int i = 0; i < length; i++) {
				String name = request.getParameter("name" + i);
				String surname = request.getParameter("surname" + i);
				String fiscalCode = request.getParameter("fiscalCode" + i);
				String date = request.getParameter("dateOfBirth" + i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String docCode = request.getParameter("docCode" + i);
				String docType = request.getParameter("docType" + i);
				String baggage = request.getParameter("baggage" + i);
				Date dataBirth;
				try {
					dataBirth = sdf.parse(date);
					Passenger p = new Passenger(fiscalCode, name, surname, docCode, docType, dataBirth, baggage);
					writePassenger(p);
					listPassenger.add(p);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			System.out.println(listPassenger);
			session.setAttribute("listPassenger", listPassenger);
			ArrayList<Flight> listFlight = new ArrayList<Flight>();
			listFlight.add((Flight) request.getSession().getAttribute("chosenDeparture"));
			listFlight.add((Flight) request.getSession().getAttribute("chosenReturn"));
			session.setAttribute("listFlight", listFlight);
			//session.setAttribute("Customer", c);

		}
	}

	public static void writePassenger(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}
}