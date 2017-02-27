package com.chat;

public class User {
	public String ip;
	public String username;
	
	public User(String ip){
		this.ip = ip;
	}
	
	public User(String ip, String username) {
		this.ip = ip;
		this.username = username;
	}

	public String toString(){
		return "<li><i class=\"fa-li fa fa-user\"></i>" + (username != null ? username : ip) + "</li>";
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof User){
			return ip.equals(((User) o).ip);
		}
		return false;
	}
}
