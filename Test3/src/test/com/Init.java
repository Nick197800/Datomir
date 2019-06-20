package test.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

//Automatikus létrehozza az objektumot, ha az @Inject annotációt rátesszük
/*
@Named
@SessionScoped
*/
@Singleton
@Startup
public class Init /* implements Serializable */{
	
	private String name;
	private HttpServletResponse response;
	
	public void Init() {

	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}
	
	@Schedule(hour = "*", minute ="*/1", persistent = false)
	public void ActiveScedule() throws IOException
	{
		
		if (response == null)
			return;
	//	System.console().writer().println("Test");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + "Test" + "</h1>");
		System.err.println("Test");
	}
	
}
