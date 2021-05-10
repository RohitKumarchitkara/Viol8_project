package com.vapl.vc.model;

public class ResponseGet {

	private long user_id;
	
	private String message;
	
	

	public ResponseGet(long user_id, String message) {
		super();
		this.user_id = user_id;
		this.message = message;
	}
    
	public ResponseGet(String message)
	{
		super();
		this.message = message;
	}
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
