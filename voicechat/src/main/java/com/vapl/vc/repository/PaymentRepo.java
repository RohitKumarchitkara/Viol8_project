package com.vapl.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vapl.vc.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
