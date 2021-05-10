package com.vapl.vc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agents_Timings {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long agent_id;
   private String agent_start_time;
   private String agent_end_time;
   
   public Agents_Timings()
   {
	   
   }
   
//public Agents_Timings(String agent_start_time, String agent_end_time) {
//	super();
//	this.agent_start_time = agent_start_time;
//	this.agent_end_time = agent_end_time;
//}
public long getAgent_id() {
	return agent_id;
}
public void setAgent_id(long agent_id) {
	this.agent_id = agent_id;
}
public String getAgent_start_time() {
	return agent_start_time;
}
public void setAgent_start_time(String agent_start_time) {
	this.agent_start_time = agent_start_time;
}
public String getAgent_end_time() {
	return agent_end_time;
}
public void setAgent_end_time(String agent_end_time) {
	this.agent_end_time = agent_end_time;
}
   
   

}
