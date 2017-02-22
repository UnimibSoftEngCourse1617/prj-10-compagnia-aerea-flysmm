package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontController.FrontCommand;
import frontController.UnknownCommand;
import sale.Flight;

/**
 * Servlet implementation class GetReturnFlight
 */
@WebServlet("/GetReturnFlight")
public class GetReturnFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		flight = null;
		List<Flight> flights = (List<Flight>) request.getSession().getAttribute("flights");
		Flight chosen = findFlightFromIdAndTariff(flights, id, tariff);
		if (chosen != null) {
			request.getSession().setAttribute("chosenDeparture", chosen);
		}
    
		FrontCommand command = getCommand(request);
		String op = request.getSession().getAttribute("rDate").toString();
		
		System.out.println(op.toString());
		if (command != null &&  !op.equals("")) {
			command.init(getServletContext(), "GRF", request, response);
			command.dispatch();
		} 
		else if(op.equals("")) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Gateway");
			dispatcher.forward(request, response);
		}else{
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
