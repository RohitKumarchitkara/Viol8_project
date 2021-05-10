package com.vapl.vc.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class Otp {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long msisdn;
	
	private int otp;
	
	private Date otp_time;
	
	private int is_verify;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(long msisdn) {
		this.msisdn = msisdn;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	

	public Date getOtp_time() {
		return otp_time;
	}

	public void setOtp_time(Date otp_time) {
		this.otp_time = otp_time;
	}

	public int getIs_verify() {
		return is_verify;
	}

	public void setIs_verify(int is_verify) {
		this.is_verify = is_verify;
	}
    
	
    	
	
	
	
	
}
