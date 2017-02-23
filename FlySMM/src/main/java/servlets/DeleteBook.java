package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append(request.getParameter("command"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("deleteBookId", request.getParameter("chosenId"));
		FrontCommand command = FrontCommand.getCommand(request, response);
		if (command != null) {
			command.init(getServletContext(), "GDF", request, response);
			command.dispatch();

		} else {
			System.out.println("CommandNotFound");
		}

	}
}
