package com.vapl.vc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.model.Agents;
import com.vapl.vc.model.Profiles;
import com.vapl.vc.service.ProfileDao;

@RestController
@RequestMapping("/")
public class ProfileController {
	
	@Autowired
	ProfileDao profiledao;
	
	@GetMapping("/allprofilescustom")
	public ResponseEntity<List<Profiles>> getAllProfiles()
	{
		List<Profiles> list = profiledao.getAll();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@PostMapping("/addprofile")
	public ResponseEntity<Profiles> addProfilesData(@RequestBody Profiles profile)
	{
		Profiles p =null;
		try
		{
			p = profiledao.addProfiles(profile);
			System.out.println(profile);
			return ResponseEntity.of(Optional.of(p));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/allprofiles")
	public ResponseEntity<List<Object[]>> getProfilesData()
	{
		List<Object[]> list = profiledao.getProfileData();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/profilesrecent")
	public ResponseEntity<List<Object[]>> getRecentData()
	{
		List<Object[]> list = profiledao.getRecentProfiles();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@GetMapping(value="/profilerecom/{id}")
	public ResponseEntity<List<Object[]>> getRecommended(@PathVariable("id") long id)
	{
		List<Object[]> list = profiledao.getById(id);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@GetMapping(value="/profile_detail/{id}")
    public Optional<Profiles> get_particular_profile(@PathVariable("id") Long id)
	{
		Optional<Profiles> profile = profiledao.get_one(id);
		return profile;
	}

}

