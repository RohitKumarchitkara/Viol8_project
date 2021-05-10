package com.vapl.vc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pack_details")
public class Pack_Details {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	private int pack_id;
	
	private int pack_price;
	
	private String pack_name;

	private int credits;
	
	private int agents;
	
	private int domains;
	
	@Column(length = 30)
	private String validity;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPack_id() {
		return pack_id;
	}

	public void setPack_id(int pack_id) {
		this.pack_id = pack_id;
	}


	public String getPack_name() {
		return pack_name;
	}

	public void setPack_name(String pack_name) {
		this.pack_name = pack_name;
	}

	public int getPack_price() {
		return pack_price;
	}

	public void setPack_price(int pack_price) {
		this.pack_price = pack_price;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getAgents() {
		return agents;
	}

	public void setAgents(int agents) {
		this.agents = agents;
	}

	public int getDomains() {
		return domains;
	}

	public void setDomains(int domains) {
		this.domains = domains;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	
	
	
	
	
	

}
