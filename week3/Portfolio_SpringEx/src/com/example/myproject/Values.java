package com.example.myproject;

import java.io.Serializable;

public class Values implements Serializable { 
		 
		   private String name;
		  
		    private String email;
		 
		    private String message;
		 
		   
		    
		    public String getName() {
		        return name;
		    }
		 
		    public void setName(String name) {
		        this.name = name;
		    }
		 
		    public String getEmail() {
		        return email;
		    }
		    public void setEmail(String email)
		    {
		    	this.email=email;
		    }
		    public void setMessage(String message) {
		        this.message= message;
		    }
		    public String getMessage() {
		        return message;
		    }
		 
		}

