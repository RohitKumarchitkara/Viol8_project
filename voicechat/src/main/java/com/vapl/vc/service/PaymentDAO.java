package com.vapl.vc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.model.Payment;
import com.vapl.vc.repository.PaymentRepo;

@Service
public class PaymentDAO {
   
	
	@Autowired
	PaymentRepo repo;
	
	
	public Payment add_paymentData(Payment payment)
	{
		Date date = new Date();
		payment.setPayment_date(date);
		payment.setPayment_update(date);
		payment.setPayment_status("true");
		return repo.save(payment);
	}
	
	public List<Payment> get_paymentDetails()
	{
		List<Payment> l = new ArrayList<>();
	   	 repo.findAll().forEach(s -> l.add(s));
	   	 return l;
	}
	
	
}
