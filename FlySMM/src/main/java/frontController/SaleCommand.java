package frontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sale.Airport;
import sale.Flight;
import servlets.HibernateProxyTypeAdapter;
import servlets.SessionFactorySingleton;

public class SaleCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getFlightFromDb();
			
			
		}
	}

	public void getFlightFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		List result = session
				.createQuery("Select icao from Airport " + "where name = '" + request.getParameter("aDeparture") + "'")
				.list();
		String departure = (String) result.get(0);

		result = session
				.createQuery("Select icao from Airport " + "where name = '" + request.getParameter("aArrival") + "'")
				.list();
		String arrival = (String) result.get(0);

		result = session.createQuery("from Flight " + "where departureAirport.icao = '" + departure + "' AND "
				+ "arrivalAirport.icao = '" + arrival + "'").list();
		session.getTransaction().commit();
		//session.close();
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		String json = gson.toJson((List<Flight>) result);
		request.setAttribute("flights", json);
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
