package com.vapl.vc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;
	
	private String role;
    
    private	String username;
	
	public Role() {
		super();
	}

	

	public Role(String role, String username) {
		super();
		this.role = role;
		this.username = username;
	}



	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
}
