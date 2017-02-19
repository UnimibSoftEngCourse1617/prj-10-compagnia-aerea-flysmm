package frontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sale.Airport;
import sale.Flight;
import sale.Price;
import servlets.HibernateProxyTypeAdapter;
import servlets.SessionFactorySingleton;

public class SaleCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getDepartureFromDb();
		}
	}

	public void getDepartureFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		List result = session
				.createQuery("Select icao from Airport " + "where name = '" + request.getParameter("aDeparture") + "'")
				.list();
		String departure = (String) result.get(0);
		request.getSession().setAttribute("dIcao", departure);
		result = session
				.createQuery("Select icao from Airport " + "where name = '" + request.getParameter("aArrival") + "'")
				.list();
		String arrival = (String) result.get(0);
		request.getSession().setAttribute("aIcao", arrival);
		result = session.createQuery("from Price p inner join p.flight f " + "where f.departureAirport.icao = '"
				+ departure + "' AND " + "f.arrivalAirport.icao = '" + arrival + "' AND f.departureDate = '"
				+ request.getParameter("dDate") + "' group by f.idFlight, p.seats.tariff").list();
		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result) {
			Price p = (Price) o[0];
			Flight f = (Flight) o[1];
			flights.add(new Flight(f, p));
		}
		session.getTransaction().commit();
		request.setAttribute("flights", flights);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/flights.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
