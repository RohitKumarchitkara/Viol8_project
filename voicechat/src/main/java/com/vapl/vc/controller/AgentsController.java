package com.vapl.vc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.model.Agents;
import com.vapl.vc.service.AgentsDao;


@RestController
@RequestMapping("/")
public class AgentsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AgentsController.class);
	
	
	@Autowired
	AgentsDao agentDao;
	
	@GetMapping("/allagentcustom")
	public ResponseEntity<List<Agents>> getAllAgents()
	{
		List<Agents> list = agentDao.getAll();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/addagent")
	public ResponseEntity<Agents> addAgentData(@RequestBody Agents agent)
	{
		Agents a =null;
		try
		{
			a = agentDao.addAgents(agent);
			//System.out.println(agent);
			logger.info("Agent Data " + agent);
			return ResponseEntity.of(Optional.of(a));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
    
	
	@GetMapping("/allagent")
	public ResponseEntity<List<Object[]>> getAgentData()
	{
		List<Object[]> list = agentDao.getData();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/agentrecent")
	public ResponseEntity<List<Object[]>> getRecentData()
	{
		List<Object[]> list = agentDao.getRecent();
		
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
    @GetMapping(value="/agentrecom/{id}")
	public ResponseEntity<List<Object[]>> getRecommended(@PathVariable("id") Long id)
	{
		List<Object[]> list = agentDao.getById(id);
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
    @GetMapping(value="/agent_detail/{id}")
    public Optional<Agents> get_particular_agent(@PathVariable("id") Long id)
	{
		Optional<Agents> agent = agentDao.get_one(id);
		return agent;
	}
	

}
