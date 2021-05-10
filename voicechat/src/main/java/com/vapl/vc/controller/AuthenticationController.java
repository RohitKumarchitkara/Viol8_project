package com.vapl.vc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.Configuration.JwtTokenUtil;
import com.vapl.vc.model.DAOUser;
import com.vapl.vc.model.JwtRequest;
import com.vapl.vc.model.JwtResponse;
import com.vapl.vc.model.ResponseGet;
import com.vapl.vc.model.Role;
import com.vapl.vc.model.UserDTO;
import com.vapl.vc.repository.UserRepository;
import com.vapl.vc.service.CustomUserDetailsService;



@RestController
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		logger.info("LOGIN : ");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		String userArr[] = userDetails.getUsername().split(";");
		//System.out.println("User Name : "+userArr[0]);
		logger.info("User Name : "+userArr[0]);
		DAOUser userDao = userDetailsService.findByName(userArr[0]);
	    //System.out.println("User ID : "+userDao.getUser_id());  
	    logger.info("User ID : "+userDao.getUser_id());
	    //System.out.println("Role : "+userDao.getRole().get(0).getRole());
	    logger.info("Role : "+userDao.getRole().get(0).getRole());
		//return ResponseEntity.ok(new JwtResponse(token);
	    String user_id = String.valueOf(userDao.getUser_id());
	    return new JwtResponse(token,user_id,userDao.getRole().get(0).getRole());
	} 
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
//		
//		logger.info("Register " + user.getUsername() + user.getPassword() + user.getName() + user.getEmail() + user.getGender());
//		
////		String user_verification = user.getUsername();
////		
////		List<DAOUser> user_info = userDetailsService.getAll();
////		
////		for(DAOUser get_user : user_info)
////		{
////			if(get_user.getUsername() == user_verification)
////			{
////				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
////			}
//		}
//		
//		return ResponseEntity.ok(userDetailsService.save(user));
//	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseGet saveUser(@RequestBody UserDTO user) throws Exception {
		
		logger.info("Register " + user.getUsername() + user.getPassword() + user.getName() + user.getEmail() + user.getGender());
		
//		String user_verification = user.getUsername();
//		
//		List<DAOUser> user_info = userDetailsService.getAll();
//		
//		for(DAOUser get_user : user_info)
//		{
//			if(get_user.getUsername() == user_verification)
//			{
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//			}
//		}
		DAOUser dao_user =  userDetailsService.save(user);
		
		return new ResponseGet(dao_user.getUser_id(),"Registration Successfull");
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/email_verification", method = RequestMethod.POST)
	public ResponseGet email_verification(@RequestBody DAOUser u)
	{
		System.out.println(u.getEmail());
	    DAOUser user = userDetailsService.findByEmail(u.getEmail());
	    
	    if(user!=null)
	    {
	    	DAOUser user_info = userDetailsService.findByEmail(u.getEmail());
	    	return new ResponseGet(user_info.getUser_id(),"Verification Successfull");
	    }
	    return new ResponseGet(0,"Not Verified");
	}
	
	@RequestMapping(value = "/reset_password/{mobile_number}", method = RequestMethod.POST)
	public ResponseEntity<?> reset_user_password(@PathVariable long mobile_number,@RequestBody DAOUser user)
	{
		userDetailsService.reset_password(user.getPassword(),mobile_number);
		return ResponseEntity.ok("Your Password Successully Updated");
	}
	
	
	

}
