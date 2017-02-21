package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.criterion.SizeExpression;
import org.hibernate.mapping.List;

import booking.Book;
import booking.Passenger;
import customer.Customer;
import frontController.FrontCommand;
import frontController.UnknownCommand;
import sale.Flight;

public class GetPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetPassenger() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append(request.getParameter("command"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FrontCommand command = getCommand(request);
		if (command != null) {
			command.init(getServletContext(), "GDF", request, response);
			command.dispatch();

		} else {
			System.out.println("CommandNotFound");
		}
		Customer c = (Customer) request.getSession().getAttribute("Customer");
		ArrayList<Passenger> listPassenger = (ArrayList<Passenger>) request.getSession().getAttribute("listPassenger");
		ArrayList<Flight> listFlight = (ArrayList<Flight>) request.getSession().getAttribute("listFlight");
		ArrayList<Integer> priceBaggage = (ArrayList<Integer>) request.getSession().getAttribute("priceBaggage");
		ArrayList<Book> listBook = new ArrayList<Book>();

		for (Flight f : listFlight) {
			int i = 0;
			for (Passenger p : listPassenger) {
				Book tmp = new Book(c, f, p);
				tmp.setTotalPrice(tmp.getTotalPrice() + priceBaggage.get(i));
				listBook.add(tmp);
				i++;
			}
		}
		request.getSession().setAttribute("listBook", listBook);
		System.out.println("quaaaa");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bookRecap.jsp");
		requestDispatcher.forward(request, response);

	}

	private FrontCommand getCommand(HttpServletRequest request) {
		FrontCommand result = null;
		try {
			return (FrontCommand) getCommandClass(request).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Class getCommandClass(HttpServletRequest request) {
		Class result;
		final String commandClassName = "frontController." + (String) request.getParameter("command") + "Command";
		try {
			result = Class.forName(commandClassName);
		} catch (ClassNotFoundException e) {
			result = UnknownCommand.class;
		}
		return result;
	}

}
