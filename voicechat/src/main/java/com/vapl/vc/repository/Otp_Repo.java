package com.vapl.vc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vapl.vc.model.Otp;

@Repository
public interface Otp_Repo extends JpaRepository<Otp, Long> {
    
	
	    public static final String FIND_OTP = "SELECT * FROM otp o where o.otp = ?1 ORDER BY o.otp_time DESC LIMIT 1";

		@Query(value = FIND_OTP , nativeQuery=true)
		public Otp findByOtp(@Param("user_otp") int user_otp);
}
