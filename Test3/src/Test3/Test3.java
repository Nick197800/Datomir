package Test3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.Init;

@WebServlet(urlPatterns = "/startweb")
public class Test3 extends HttpServlet {

	private String message;
	HttpServletResponse response;
	
	@Inject
	private Init m_Init;

	public void init() throws ServletException {
		// Do required initialization

		message = "Start GlassFish";
		m_Init.setName("Sajat2");
		
		
		String name = m_Init.getName();
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("")
		this.response = response;
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		m_Init.setResponse(response);
	}

	public void destroy() {
		// do nothing.
	}
}
