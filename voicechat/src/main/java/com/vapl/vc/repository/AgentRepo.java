package com.vapl.vc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.oneToMany.entity.Agents;
//import com.oneToMany.entity.ObjectConverter;
import com.vapl.vc.model.*;
@Repository
public interface AgentRepo extends JpaRepository<Agents, Long> {
	
	 public static final String FIND_AGENT = "SELECT a.agent_id,a.agent_name,a.agent_status,a.agent_gender,a.agent_iterest,a.agent_age FROM agents a";
     
//	 public static final String FIND_AGENT = "SELECT * FROM agents a";

	@Query(value = FIND_AGENT , nativeQuery=true)
	public List<Object[]> getSelectedInfo();
	
	
	public static final String FIND_AGENT_RECENT = "SELECT a.agent_id,a.agent_name,a.agent_status,a.agent_gender,a.agent_iterest,a.agent_age FROM agents a where a.agent_status=1  order by a.agent_id DESC limit 7";
	
	@Query(value = FIND_AGENT_RECENT , nativeQuery=true)
	public List<Object[]> getRecent();
	
	public static final String FIND_AGENT_GENDER = "SELECT a.agent_id,a.agent_name,a.agent_status,a.agent_gender,a.agent_iterest,a.agent_age FROM agents a where a.agent_status=1 AND a.agent_gender = 'F'";
	    
	
	@Query(value = FIND_AGENT_GENDER , nativeQuery=true)
	public List<Object[]> getByGender();
	
	public static final String FIND_AGENT_GENDER1 = "SELECT a.agent_id,a.agent_name,a.agent_status,a.agent_gender,a.agent_iterest,a.agent_age FROM agents a WHERE a.agent_status=1 AND a.agent_gender = 'M'";
	
	
	@Query(value = FIND_AGENT_GENDER1 , nativeQuery=true)
	public List<Object[]> getByMale();
	
	
}
