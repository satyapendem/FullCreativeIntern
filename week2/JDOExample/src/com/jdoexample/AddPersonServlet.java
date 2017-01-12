package com.jdoexample;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddPersonServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		 String name = req.getParameter("uname");
		 Person p = new Person(name);

		 PersistenceManager pm = PerManFact.get().getPersistenceManager();

		 try
		 {
		 	
		     pm.makePersistent(p);

		 }
		 
		 finally
		 {
		 	
		 	pm.close();
		 }
		 
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello,"+name);
	}
}
