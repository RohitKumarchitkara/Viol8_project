package com.vapl.vc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long agent_id;
	
	private String agent_name;
	private String agent_number;
	private String agent_email;
	private int agent_age;
	private String agent_gender;
	private int agent_status;
	private String agent_creation_date;
	private String agent_updation_date;
	private String agent_iterest;
	
	@Column(name="agent_last_call_date")
	private String agent_LastCall_date;
	private long user_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "at_fk" , referencedColumnName = "agent_id")
	List<Agents_Timings> agent_timing = new ArrayList<>();
	 
	public List<Agents_Timings> getAgent_timing() {
		return agent_timing;
	}


	public void setAgent_timing(List<Agents_Timings> agent_timing) {
		this.agent_timing = agent_timing;
	}


	public Agents()
	{
		
	}

	
	
	public long getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(long agent_id) {
		this.agent_id = agent_id;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	public String getAgent_number() {
		return agent_number;
	}
	public void setAgent_number(String agent_number) {
		this.agent_number = agent_number;
	}
	public String getAgent_email() {
		return agent_email;
	}
	public void setAgent_email(String agent_email) {
		this.agent_email = agent_email;
	}
	public int getAgent_age() {
		return agent_age;
	}
	public void setAgent_age(int agent_age) {
		this.agent_age = agent_age;
	}
	public String getAgent_gender() {
		return agent_gender;
	}
	public void setAgent_gender(String agent_gender) {
		this.agent_gender = agent_gender;
	}
	public int getAgent_status() {
		return agent_status;
	}
	public void setAgent_status(int agent_status) {
		this.agent_status = agent_status;
	}
	public String getAgent_creation_date() {
		return agent_creation_date;
	}
	public void setAgent_creation_date(String agent_creation_date) {
		this.agent_creation_date = agent_creation_date;
	}
	public String getAgent_updation_date() {
		return agent_updation_date;
	}
	public void setAgent_updation_date(String agent_updation_date) {
		this.agent_updation_date = agent_updation_date;
	}
	public String getAgent_iterest() {
		return agent_iterest;
	}
	public void setAgent_iterest(String agent_iterest) {
		this.agent_iterest = agent_iterest;
	}
	public String getAgent_LastCall_date() {
		return agent_LastCall_date;
	}
	public void setAgent_LastCall_date(String agent_LastCall_date) {
		this.agent_LastCall_date = agent_LastCall_date;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	

}
