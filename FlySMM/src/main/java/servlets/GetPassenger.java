package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import booking.Book;
import booking.Passenger;
import customer.Customer;
import frontcontroller.FrontCommand;
import sale.Flight;

public class GetPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(GetPassenger.class);
	
	public GetPassenger() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Empty because useless
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e1) {
			LOG.error("An error in getCommand occured", e1);
		}
		if (command != null) {
			command.init(getServletContext(), "GDF", request, response);
			try {
				command.dispatch();
			} catch (Exception e2) {
				LOG.error("An error in dispatch occured", e2);
				}

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
				if (c.getClass().toString().matches("class customer.FidelityCustomer")) {
					tmp.setTotalPrice(f.getPrice().getDiscountedAmount());
				}
				tmp.setTotalPrice(tmp.getTotalPrice() + priceBaggage.get(i));
				listBook.add(tmp);
				i++;
			}
		}
		float totalPrice = 0;
		for (Book b : listBook) {
			totalPrice += b.getTotalPrice();
		}
		request.setAttribute("totalPrice", totalPrice);

		request.getSession().setAttribute("listBook", listBook);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bookRecap.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (Exception e3) {
			LOG.error("An error occured", e3);
			}
	}
}
