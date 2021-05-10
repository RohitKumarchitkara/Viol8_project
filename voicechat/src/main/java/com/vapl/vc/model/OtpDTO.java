package com.vapl.vc.model;

import java.time.LocalTime;
import java.util.Date;

public class OtpDTO {
	
private long msisdn;
	
	private int otp;
	
	private LocalTime otp_time;
	
	private String is_verify;

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

	

	public LocalTime getOtp_time() {
		return otp_time;
	}

	public void setOtp_time(LocalTime otp_time) {
		this.otp_time = otp_time;
	}

	public String getIs_verify() {
		return is_verify;
	}

	public void setIs_verify(String is_verify) {
		this.is_verify = is_verify;
	}
	
	

}
