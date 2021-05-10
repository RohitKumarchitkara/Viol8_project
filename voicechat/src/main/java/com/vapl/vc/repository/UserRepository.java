package com.vapl.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vapl.vc.model.DAOUser;


@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);
	
	
	public static final String FIND_USER = "SELECT * FROM user_details u where u.email = ?1";
  
	@Query(value = FIND_USER , nativeQuery=true)
	DAOUser findByEmail(@Param("email") String email);
	
	public static final String USER_UPDATE = "UPDATE user_details u set u.password = ?1,u.decode_password = ?2 WHERE u.number = ?3";
    
	@Modifying
	@Transactional
	@Query(value = USER_UPDATE , nativeQuery=true)
	void reset_password(@Param("password") String password,@Param("decode_password") String decode_password,@Param("mobile_number") long mobile_number);
	
}
