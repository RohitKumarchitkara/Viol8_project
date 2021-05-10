package com.vapl.vc.controller;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.model.Agents;
import com.vapl.vc.model.Otp;
import com.vapl.vc.model.OtpDTO;
import com.vapl.vc.service.OtpDAO;

@RestController
@RequestMapping("/")
public class OtpController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(OtpController.class);
	
	@Autowired
	OtpDAO otpDao;
	
	
	@PostMapping("/addOtpData")
	public ResponseEntity<?> addAgentData(@RequestBody OtpDTO data)	
	{	
		return ResponseEntity.ok(otpDao.add_Otp_data(data));
	}
    
	@PostMapping("/verify_otp")
	public ResponseEntity<?> Check(@RequestBody OtpDTO data)
	{
		int getOTP = data.getOtp();
		boolean check = otpDao.verifyOtp(getOTP);
		if(check == true)
		{
			return ResponseEntity.status(HttpStatus.OK).build(); 
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@PostMapping("/registration_otp")
	public ResponseEntity<?> registration_otp(@RequestBody OtpDTO data)	
	{	
		return ResponseEntity.ok(otpDao.generate_registration_otp(data));
	}
	
	@PostMapping("/verify_registration_otp")
	public ResponseEntity<?> verify_registration_otp(@RequestBody OtpDTO data)
	{
		int getOTP = data.getOtp();
		boolean check = otpDao.verify_otp_registration(getOTP);
		if(check == true)
		{
			return ResponseEntity.status(HttpStatus.OK).build(); 
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
