package com.chat;

public class Message {
	public String message;
	public User user;
	
	public Message(User user, String message){
		this.user = user;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return (user.username != null ? user.username : user.ip) + ": " + message;
	}
}
