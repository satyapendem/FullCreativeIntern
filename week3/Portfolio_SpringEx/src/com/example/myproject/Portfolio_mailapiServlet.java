package com.example.myproject;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Portfolio_mailapiServlet {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/sendEmail.do", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	String sendEmail(@ModelAttribute("v") Values v) throws Exception,MailException {
 
		 String res;
		String name=v.getName();
   		String mail=v.getEmail();
   		String message = v.getMessage();
   		System.out.println(name);
		if(name==null && mail==null && message==null)
		{
			
			System.out.println("cannot send an email");
		return null;
		}
		else
		{
		message = mail + " " + message;
		String recipientAddress = "satyasoft515@gmail.com";
		System.out.println("name: " + name);
		System.out.println("mail: " + mail);
		System.out.println("Message: " + message);
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(name);
		email.setText(message);

		mailSender.send(email);

		res = "Mail sent Successfully!!!";
      
		return res;
		}
	}
}
