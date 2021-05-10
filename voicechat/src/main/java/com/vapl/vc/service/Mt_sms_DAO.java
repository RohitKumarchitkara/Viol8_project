package com.vapl.vc.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.model.Mt_SMS;
import com.vapl.vc.model.SMS_DTO;
import com.vapl.vc.repository.Mt_Sms_Repo;

@Service
public class Mt_sms_DAO {
	
	private static final Logger logger = LoggerFactory.getLogger(OtpDAO.class);
	
	@Autowired
	Mt_Sms_Repo sms_repo;
	
	
	public Mt_SMS save_sms_data(SMS_DTO data)
	{
		Mt_SMS sms = new Mt_SMS();
		sms.setMsisdn(data.getMsisdn());
		Date date = new Date();
		sms.setReq_date(date);
		sms.setShortcode("TAPPER");
		sms.setSms_status("0");
		sms.setStatus("0");
		sms.setSms_text("Your verification Otp is " + data.getSms_text());
		sms.setSms_type("0");
		sms.setTrans_id(0);
		sms.setUser_id(0);
		
		sms_repo.save(sms);
		
		return sms;	
	}

}
