package com.vapl.vc.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profiles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long profile_id;
	
	private String profile_name;
	private long profile_number;
	private String profile_email;
	private int profile_age;
	
	@Column(length = 3)
	private String profile_gender;
	
	@Column(length = 1)
	private int profile_status;
	
	private Date profile_creation_date;
	private Date profile_updation_date;
	private String profile_interest;
	private Date profile_LastCall_date;
	
	private int profile_score;
	
	private long user_id;
	
	private String profile_image_url;
	
	public Profiles()
	{
		
	}
	
	public long getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public long getProfile_number() {
		return profile_number;
	}
	public void setProfile_number(long profile_number) {
		this.profile_number = profile_number;
	}
	public String getProfile_email() {
		return profile_email;
	}
	public void setProfile_email(String profile_email) {
		this.profile_email = profile_email;
	}
	public int getProfile_age() {
		return profile_age;
	}
	public void setProfile_age(int profile_age) {
		this.profile_age = profile_age;
	}
	public String getProfile_gender() {
		return profile_gender;
	}
	public void setProfile_gender(String profile_gender) {
		this.profile_gender = profile_gender;
	}
	public int getProfile_status() {
		return profile_status;
	}
	public void setProfile_status(int profile_status) {
		this.profile_status = profile_status;
	}
	public Date getProfile_creation_date() {
		return profile_creation_date;
	}
	public void setProfile_creation_date(Date profile_creation_date) {
		this.profile_creation_date = profile_creation_date;
	}
	public Date getProfile_updation_date() {
		return profile_updation_date;
	}
	public void setProfile_updation_date(Date profile_updation_date) {
		this.profile_updation_date = profile_updation_date;
	}
	public String getProfile_interest() {
		return profile_interest;
	}
	public void setProfile_interest(String profile_interest) {
		this.profile_interest = profile_interest;
	}
	public Date getProfile_LastCall_date() {
		return profile_LastCall_date;
	}
	public void setProfile_LastCall_date(Date profile_LastCall_date) {
		this.profile_LastCall_date = profile_LastCall_date;
	}

	public int getProfile_score() {
		return profile_score;
	}

	public void setProfile_score(int profile_score) {
		this.profile_score = profile_score;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	
	

}
