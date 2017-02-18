package frontController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrontCommand {
	protected ServletContext context;
	protected String caller;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	

	public void init(ServletContext context, String caller, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;
		this.caller = caller;
		this.request = request;
		this.response = response;
	}

	abstract public void dispatch() throws ServletException, IOException;

}
