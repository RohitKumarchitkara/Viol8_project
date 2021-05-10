package com.vapl.vc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.model.OtpDTO;
import com.vapl.vc.model.SMS_DTO;
import com.vapl.vc.service.Mt_sms_DAO;

@RestController
@RequestMapping("/")
public class sms_controller {

	private static final Logger logger = LoggerFactory.getLogger(OtpController.class);
	
	@Autowired 
	Mt_sms_DAO dao;
	
	
	@PostMapping("/add_sms_data")
	public ResponseEntity<?> addAgentData(@RequestBody SMS_DTO data)	
	{	
		return ResponseEntity.ok(dao.save_sms_data(data));
	}  
	
	
}
