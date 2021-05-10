package com.vapl.vc.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	private String user_id;
	
	private String user_role;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	

	public JwtResponse(String jwttoken, String user_id, String user_role) {
		super();
		this.jwttoken = jwttoken;
		this.user_id = user_id;
		this.user_role = user_role;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getUser_role() {
		return user_role;
	}



	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}



	public String getToken() {
		return this.jwttoken;
	}
}
