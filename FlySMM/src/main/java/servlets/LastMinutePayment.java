package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import booking.Book;
import customer.Customer;

/**
 * Servlet implementation class LastMinutePayment
 */
public class LastMinutePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LastMinutePayment.class);

	public LastMinutePayment() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> book = (List<Book>) request.getSession().getAttribute("listBook");
		Customer customer = (Customer) request.getSession().getAttribute("Customer");

		ServletUtility.initAndDispatch(getServletContext(), request, response, "lastMinute");

	}
}
