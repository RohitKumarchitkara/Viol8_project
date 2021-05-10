package com.vapl.vc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length = 128)
	private String payment_id;
	
	private int pack_id;
	
	private long user_id;
	
	private String payment_status;
	
	private String payment_reason;
	
	private Date payment_date;
	
	private Date payment_update;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public int getPack_id() {
		return pack_id;
	}

	public void setPack_id(int pack_id) {
		this.pack_id = pack_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_reason() {
		return payment_reason;
	}

	public void setPayment_reason(String payment_reason) {
		this.payment_reason = payment_reason;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public Date getPayment_update() {
		return payment_update;
	}

	public void setPayment_update(Date payment_update) {
		this.payment_update = payment_update;
	}
	
	
	
	
	
	
}
