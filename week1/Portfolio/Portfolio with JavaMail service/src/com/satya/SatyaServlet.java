package com.satya;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SatyaServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String mail = request.getParameter("email");
        String message =  request.getParameter("message");
        send(name, message,mail);
        out.println("Mail send successfully");
                
	}
public static void send(String name, 
            String msg,final String uemail)
{ 
		
Properties props = new Properties();
Session session = Session.getDefaultInstance(props,null);
try
{

Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("murthy.veeranna@adaptavantcloud.com","from cotact form"));
message.addRecipient(Message.RecipientType.TO,new InternetAddress("satyasoft515@gmail.com"));
message.setSubject(name);
message.setText(msg);
Transport.send(message);
}
catch(Exception e)
{
e.printStackTrace();
}
}
}