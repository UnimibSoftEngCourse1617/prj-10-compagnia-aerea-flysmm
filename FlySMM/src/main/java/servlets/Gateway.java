package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import sale.Flight;

/**
 * Servlet implementation class Recap
 */
public class Gateway extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(Gateway.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gateway() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] flight = request.getParameter("chosen").split("-");
		String id = flight[0];
		String tariff = flight[1];
		List<Flight> flights = (List<Flight>) request.getSession().getAttribute("flights");
		Flight chosen = findFlightFromIdAndTariff(flights, id, tariff);
		if (chosen != null) {
			request.getSession().setAttribute("chosenReturn", chosen);
		}

		RequestDispatcher dispatcher;
		System.out.println(request.getSession().getAttribute("idCustomer"));
		if (request.getSession().getAttribute("idCustomer") == null)
			dispatcher = request.getRequestDispatcher("/loginPage.html");
		else
			dispatcher = request.getRequestDispatcher("/addPassenger.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			LOG.error("An error occured", e);
		} catch (IOException e) {
			LOG.error("An error occured", e);
		}
	}

	private Flight findFlightFromIdAndTariff(List<Flight> flights, String id, String tariff) {
		for (Flight temp : flights) {
			if (temp.getIdFlight().equals(id) && temp.getPrice().getSeats().getTariff().equals(tariff))
				return temp;
		}
		return null;
	}

}
