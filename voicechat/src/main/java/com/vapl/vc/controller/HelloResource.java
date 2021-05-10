package com.vapl.vc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@RequestMapping( "/welcome" )
	public String Hello()
	{
		return "Hello World";
	}

}
