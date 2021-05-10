package com.vapl.vc.model;

import java.util.Date;

public class SMS_DTO {
	
private String msisdn;
	
	private String sms_text;
	
	private Date req_date;
	
	private String shortcode;
	
	private String status;
	
	private String sms_type;
	
	private long user_id;
	
	private String sms_status;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getSms_text() {
		return sms_text;
	}

	public void setSms_text(String sms_text) {
		this.sms_text = sms_text;
	}

	public Date getReq_date() {
		return req_date;
	}

	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSms_type() {
		return sms_type;
	}

	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getSms_status() {
		return sms_status;
	}

	public void setSms_status(String sms_status) {
		this.sms_status = sms_status;
	}
	
	
	

}
