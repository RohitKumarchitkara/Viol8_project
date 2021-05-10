package com.vapl.vc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.model.Agents;
import com.vapl.vc.model.Profiles;
import com.vapl.vc.repository.ProfileRepo;

@Service
public class ProfileDao {
	
	@Autowired
	ProfileRepo repo;
	
	public List<Profiles> getAll()
    {
   	 List<Profiles> l = new ArrayList<>();
   	 repo.findAll().forEach(s -> l.add(s));
   	 return l;
    }
	
	public Profiles addProfiles(Profiles p)
    {
   	 repo.save(p);
   	 return p;
    }
	
	 public List<Object[]> getProfileData()
	 {
		 List<Profiles> l = new ArrayList<>();
		 List<Object[]> l1 = new ArrayList<>();
		 l1 = repo.getSelectedInfo();
	     return l1;
	 }
	
	 public List<Object[]> getRecentProfiles()
	 {
		 List<Object[]> l = new ArrayList<>();
		 l = repo.getRecent();
		 //Get Value from object Array with the help of get method...............
//		 String g = (String)Arrays.asList(l.get(0)).get(3);
//		 System.out.println(g);
	     return l;
	 }
	 
	 
	 public List<Object[]> getById(long id)
	 {
		 Profiles op = repo.findByUserId(id);
		 int status = op.getProfile_status();
		 String gender = op.getProfile_gender();
		 System.out.println(status + " " + gender);
		 List<Object[]> a = new ArrayList<>();
		 if(status==0)
		 {
		     if(gender.equals("M"))
		         {
			        a = repo.getByGender();
			        System.out.println("This one ");
		         }
		    else
		        {
			       a = repo.getByMale();
			       System.out.println("This two");
		        }
		 }
		 else
		 {
			 System.out.println("Your Status is 0 .So Please Set your Status to 1..");
		 }
		 return a;
	 }
	
	 
	 public Optional<Profiles> get_one(Long userId)
	 {
		 Optional<Profiles> op = repo.findById(userId);
		 return op;
	 }

}

