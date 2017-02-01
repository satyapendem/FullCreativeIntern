package com.chat;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Users")
public class Users extends HttpServlet {
	static List<User> users = new ArrayList<User>();
	static List<Message> messages = new ArrayList<Message>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			User user = new User(request.getRemoteAddr());
			
			if(!users.contains(user)) {
				users.add(user);
			}
		}
		
		StringBuilder output = new StringBuilder();
		
		for(User user: users){
			output.append(user.toString());
		}
		
		response.getOutputStream().print(output.toString());
	}
}
