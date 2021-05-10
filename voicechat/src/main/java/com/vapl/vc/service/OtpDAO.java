package com.vapl.vc.service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.model.Otp;
import com.vapl.vc.model.OtpDTO;
import com.vapl.vc.repository.Otp_Repo;

@Service
public class OtpDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(OtpDAO.class);
	
	
	@Autowired
	Otp_Repo otpRepo;
	
	
	public Otp add_Otp_data(OtpDTO data)
	{
		Otp otp = new Otp();
		otp.setMsisdn(data.getMsisdn());
		int i = new java.util.Random().nextInt(900000) + 100000;
		otp.setOtp(i);
		Date date = new Date();
		
		otp.setOtp_time(date);
		otp.setIs_verify(0);
		otpRepo.save(otp);
		return otp;
	}
	
	public boolean verifyOtp(int getOpt)
	{
		boolean flag = false;
		Otp otp = otpRepo.findByOtp(getOpt);
		if(otp !=null)
		{
			flag =true;
		}
		return flag;
	} 
	
	public Otp generate_registration_otp(OtpDTO data)
	{
		Otp otp = new Otp();
		otp.setMsisdn(data.getMsisdn());
		int i = new java.util.Random().nextInt(900000) + 100000;
		otp.setOtp(i);
		Date date = new Date();
		
		otp.setOtp_time(date);
		otp.setIs_verify(0);
		otpRepo.save(otp);
		return otp;
	}
	
	public boolean verify_otp_registration(int getOpt)
	{
		boolean flag = false;
		Otp otp = otpRepo.findByOtp(getOpt);
		if(otp !=null)
		{
			flag =true;
		}
		return flag;
	}
	

}
