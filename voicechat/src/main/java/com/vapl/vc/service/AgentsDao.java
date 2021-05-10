package com.vapl.vc.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.repository.*;
import com.vapl.vc.controller.AgentsController;
//import com.oneToMany.entity.Agents;
//import com.oneToMany.entity.ObjectConverter;
//import com.oneToMany.repository.AgentRepo;
import com.vapl.vc.model.*;
@Service
public class AgentsDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AgentsDao.class);
	
	
	@Autowired
	AgentRepo agentRepo; 
	
	public List<Agents> getAll()
    {
   	 List<Agents> l = new ArrayList<>();
   	 agentRepo.findAll().forEach(s -> l.add(s));
   	 return l;
    }
	
	 public Agents addAgents(Agents a)
     {
    	 agentRepo.save(a);
    	 return a;
     }

	 public List<Object[]> getData()
	 {
		 List<Agents> l = new ArrayList<>();
		 List<Object[]> l1 = new ArrayList<>();
		 l1 = agentRepo.getSelectedInfo();
	     return l1;
	 }
	 
	 public List<Object[]> getRecent()
	 {
		 List<Object[]> l = new ArrayList<>();
		 l = agentRepo.getRecent();
//		 String g = (String)Arrays.asList(l.get(0)).get(3);
//		 System.out.println(g);
	     return l;
	 } 
	
	 
//	 public Agents getRecom(Long id)
//	 {
////		Object a = new Agents();
////		 a = agentRepo.findById(id);
////		 System.out.println(((Agents) a).getAgent_id());
////		 System.out.println(((Agents) a).getAgent_gender());
//		 Optional<Agents> agenttResponse =  agentRepo.findById(id);
//		 return agenttResponse;
//		 
//	 }
//	
	 public List<Object[]> getById(Long userId)
	 {
		 Optional<Agents> op = agentRepo.findById(userId);
		 //System.out.println(op.get().getAgent_gender());
		 logger.info("Agent Gender"+ op.get().getAgent_gender());
		 
		 int status = op.get().getAgent_status();
		 String gender = op.get().getAgent_gender();
		 List<Object[]> a = new ArrayList<>();
		 if(status==1)
		 {
		     if(gender.equals("M"))
		         {
			        a = agentRepo.getByGender();
			        //System.out.println("This one ");
			        logger.info("This One ");
		         }
		    else
		        {
			       a = agentRepo.getByMale();
			       //System.out.println("This two");
			       logger.info("This Two ");
		        }
		 }
		 else
		 {
			 //System.out.println("Your Status is 0 .So Please Set your Status to 1..");
			 logger.info("Your Status is 0 .So Please Set your Status to 1..");
		 }
		 return a;
	 }
	 public Optional<Agents> get_one(Long userId)
	 {
		 Optional<Agents> op = agentRepo.findById(userId);
		 return op;
	 }

}
