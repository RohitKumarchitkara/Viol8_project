package com.vapl.vc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_details" , uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class DAOUser {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private long number;
	
	private int age;
	
	private String gender;
	
	private String decode_password;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_userid" , referencedColumnName = "user_id")
	List<Role> role = new ArrayList<>();
	
	
	
	
	
	private Date re_date;
	
	private Date update_date;
	
	private Date expiry_date;
	
	private float credit_available;
	
	private float credit_used;
	
	private float unit_rate;
	
	private int parent;
	
	private String type;
	
	private String parent_company;
	
	private int pulse_duration;
	
	private int flag;
	
	private String logo;
	
	private String domain;
	
	
	
	

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

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

	public Date getRe_date() {
		return re_date;
	}

	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public float getCredit_available() {
		return credit_available;
	}

	public void setCredit_available(float credit_available) {
		this.credit_available = credit_available;
	}

	public float getCredit_used() {
		return credit_used;
	}

	public void setCredit_used(float credit_used) {
		this.credit_used = credit_used;
	}

	public float getUnit_rate() {
		return unit_rate;
	}

	public void setUnit_rate(float unit_rate) {
		this.unit_rate = unit_rate;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParent_company() {
		return parent_company;
	}

	public void setParent_company(String parent_company) {
		this.parent_company = parent_company;
	}

	public int getPulse_duration() {
		return pulse_duration;
	}

	public void setPulse_duration(int pulse_duration) {
		this.pulse_duration = pulse_duration;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	
	
	
	
	
}
