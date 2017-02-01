package com.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder output = new StringBuilder();
		
		for(Message message: Users.messages){
			output.append(message + "<br>");
		}
		
		response.getOutputStream().print(output.toString());
	}
}
