package com.vapl.vc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vapl.vc.controller.AuthenticationController;

@SpringBootApplication
public class VoicechatApplication {

	public static void main(String[] args) {
	    final Logger logger = LoggerFactory.getLogger(VoicechatApplication.class);
		
		SpringApplication.run(VoicechatApplication.class, args);
		//System.out.println("Successfull");
		logger.info("Successull");
	}

}