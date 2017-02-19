package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.criterion.SizeExpression;
import org.hibernate.mapping.List;

import frontController.FrontCommand;
import frontController.UnknownCommand;


public class GetUsernamePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUsernamePassword() {
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
