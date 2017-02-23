package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import frontController.FrontCommand;
import sale.Flight;

/**
 * Servlet implementation class GetReturnFlight
 */
@WebServlet("/GetReturnFlight")
public class GetReturnFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(GetReturnFlight.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetReturnFlight() {
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
			request.getSession().setAttribute("chosenDeparture", chosen);
		}

		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
		String op = (String) request.getSession().getAttribute("rDate");
		System.out.println(op);
		if (command != null && !"".equals(op)) {
			command.init(getServletContext(), "GRF", request, response);
			try {
				command.dispatch();
			} catch (Exception e) {
				LOG.error("An error occured", e);
			}
		} else if ("".equals(op)) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Gateway");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				LOG.error("An error occured", e);
			}
		} else {
			System.out.println("CommandNotFound");
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
