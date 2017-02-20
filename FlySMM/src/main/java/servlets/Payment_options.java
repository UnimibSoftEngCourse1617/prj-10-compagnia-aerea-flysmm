package servlets;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.relational.Database;

import com.mysql.fabric.xmlrpc.base.Data;

import customer.Customer;
import frontController.FrontCommand;
import frontController.UnknownCommand;
import sale.Address;
import sale.Payment;

/**
 * Servlet implementation class Payment_options
 */
public class Payment_options extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Payment_options() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append(request.getParameter("command"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FrontCommand command = getCommand(request);

		if (command != null) {
			command.init(getServletContext(), "GDF", request, response);
			command.dispatch();
		} else {
			System.out.println("CommandNotFound");
		}
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
