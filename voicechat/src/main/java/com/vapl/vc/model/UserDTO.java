package com.vapl.vc.model;

public class UserDTO {
  
    private String username;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private long number;
	
	private int age;
	
	private String gender;
	
	private String decode_password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDecode_password() {
		return decode_password;
	}

	public void setDecode_password(String decode_password) {
		this.decode_password = decode_password;
	}
	
	
	
	
}
