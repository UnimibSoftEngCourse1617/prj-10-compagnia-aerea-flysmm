package frontController;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	private Time time = new Time(8, 0, 0);
	private Price price = new Price();
	Aircraft acf = new Aircraft(77654, "Boeing", 1000, 2737, "737");
	Airport a1 = new Airport("MXP", "Malpensa");
	Airport a2 = new Airport("LIN", "Linate");
	Flight f = new Flight(acf, time, time, "abc1", data, a1, data, a2, price);
	Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String fiscalCode = request.getParameter("fiscalCode");
			String date = request.getParameter("dateOfBirth");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String docCode = request.getParameter("docCode");
			String docType = request.getParameter("docType");
			String baggage = request.getParameter("baggage");

			Date dataBirth;
			try {
				dataBirth = sdf.parse(date);
				Passenger p = new Passenger(fiscalCode, name, surname, docCode, docType, dataBirth, baggage);
				HttpSession session = request.getSession();
				session.setAttribute("Passenger", p);
				session.setAttribute("Flight", f);
				session.setAttribute("Customer", c);
				writePassenger(p);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void writePassenger(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}
}