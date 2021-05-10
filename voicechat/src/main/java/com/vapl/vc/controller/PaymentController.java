package com.vapl.vc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vapl.vc.model.Payment;
import com.vapl.vc.service.PaymentDAO;

@RestController
@RequestMapping("/")
public class PaymentController {

	@Autowired
	PaymentDAO paymentDao;
	
	
	@PostMapping("/addPaymentDetails")
	public ResponseEntity<Payment> addPaymentData(@RequestBody Payment payment)
	{
		Payment getPayment =null;
		try
		{
			getPayment = paymentDao.add_paymentData(payment);
			return ResponseEntity.of(Optional.of(getPayment));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/allpayments")
	public ResponseEntity<List<Payment>> getPaymentData()
	{
		List<Payment> list = paymentDao.get_paymentDetails();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	
	
}
