package com.vapl.vc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vapl.vc.controller.AgentsController;
import com.vapl.vc.controller.ProfileController;
import com.vapl.vc.model.DAOUser;
import com.vapl.vc.model.Profiles;
import com.vapl.vc.model.Role;
import com.vapl.vc.model.UserDTO;
import com.vapl.vc.repository.ProfileRepo;
import com.vapl.vc.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	
	@Autowired
	private UserRepository userDao;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private ProfileRepo pro_repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DAOUser user = userDao.findByUsername(username);
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
	}
	
	
//	public DAOUser save(UserDTO user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setName(user.getName());
//		newUser.setEmail(user.getEmail());
//		newUser.setNumber(user.getNumber());
//		newUser.setAge(user.getAge());
//		newUser.setGender(user.getGender());
//		newUser.setDecode_password(user.getPassword());
//		newUser.setRole(Arrays.asList(new Role("ROLE_USER",user.getUsername())));
//		 
//		Date date = new Date();
//		
//		newUser.setUpdate_date(date);
//		newUser.setRe_date(date);
//		newUser.setExpiry_date(date);
//		newUser.setCredit_available((float)9.1);
//		newUser.setCredit_used((float)9.1);
//		newUser.setUnit_rate((float)1.1);
//		newUser.setParent(1);
//		newUser.setType("ABC");
//		newUser.setParent_company("ABC_Parent");
//		newUser.setPulse_duration(60);
//		newUser.setFlag(1);
//		newUser.setLogo("logo");
//		newUser.setDomain("Domain");
//		
////		UserCheck userCheck = new UserCheck(newUser.getUser_id(),newUser.getUsername(),newUser.getPassword(),1);
////		 
////		userCheckRepo.save(userCheck);
//
//		
//		return userDao.save(newUser);
//	}
//	
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setNumber(user.getNumber());
		newUser.setAge(user.getAge());
		newUser.setGender(user.getGender());
		newUser.setDecode_password(user.getPassword());
		newUser.setRole(Arrays.asList(new Role("ROLE_USER",user.getUsername())));
		 
		Date date = new Date();
		
		newUser.setUpdate_date(date);
		newUser.setRe_date(date);
		newUser.setExpiry_date(date);
		newUser.setCredit_available((float)9.1);
		newUser.setCredit_used((float)9.1);
		newUser.setUnit_rate((float)1.1);
		newUser.setParent(1);
		newUser.setType("ABC");
		newUser.setParent_company("ABC_Parent");
		newUser.setPulse_duration(60);
		newUser.setFlag(1);
		newUser.setLogo("logo");
		newUser.setDomain("Domain");
		
//		UserCheck userCheck = new UserCheck(newUser.getUser_id(),newUser.getUsername(),newUser.getPassword(),1);
//		 
//		userCheckRepo.save(userCheck);
		userDao.save(newUser);
		
		
		Profiles profile = new Profiles();
		profile.setProfile_name(user.getName());
		profile.setProfile_age(user.getAge());
		profile.setProfile_email(user.getEmail());
		profile.setProfile_gender(user.getGender());
		Date pro_date = new Date();
		profile.setProfile_creation_date(pro_date);
		profile.setProfile_interest("ABCD");
		profile.setProfile_LastCall_date(pro_date);
        profile.setProfile_number(user.getNumber());
        profile.setProfile_status(0);
        profile.setProfile_score(9);
        profile.setProfile_updation_date(pro_date);
        profile.setUser_id(newUser.getUser_id());
        profile.setProfile_image_url("");
        pro_repo.save(profile);
        
		return newUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	public DAOUser findByName(String username)
	{
		return userDao.findByUsername(username);
	}
	
	public List<DAOUser> getAll()
	{
		return userDao.findAll();
	}
	
	public DAOUser findByEmail(String email)
	{
		DAOUser user = userDao.findByEmail(email);
		//System.out.println(user);
		logger.info("Find User By Email : "+user);
		return user;
	}
    
	public void reset_password(String password,long mobile_number)
	{
		String encode_password = bcryptEncoder.encode(password);
		//System.out.println(id + " "+ encode_password);
		logger.info("Encode Password "+encode_password);
		String decode_password = password;
		//String number=String.valueOf(mobile_number);
		userDao.reset_password(encode_password,decode_password,mobile_number);
	}
}