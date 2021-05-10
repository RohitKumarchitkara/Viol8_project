package com.vapl.vc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vapl.vc.model.Profiles;

@Repository
public interface ProfileRepo extends JpaRepository<Profiles, Long> {
   
	public static final String FIND_Profile = "SELECT p.profile_id,p.profile_name,p.profile_status,p.profile_gender,p.profile_interest,p.profile_age FROM profiles p";
    
	@Query(value = FIND_Profile , nativeQuery=true)
	public List<Object[]> getSelectedInfo();
	
	
	public static final String FIND_By_UserId = "SELECT  * FROM profiles p where p.user_id = ?1";
    
	@Query(value = FIND_By_UserId , nativeQuery=true)
	public Profiles findByUserId(@Param("user_id") long user_id);
	
	
	
    public static final String FIND_Profile_RECENT = "SELECT p.profile_id,p.profile_name,p.profile_status,p.profile_gender,p.profile_interest,p.profile_age FROM profiles p order by p.profile_id DESC limit 6";
	
	@Query(value = FIND_Profile_RECENT , nativeQuery=true)
	public List<Object[]> getRecent();
	
    public static final String FIND_Profile_GENDER = "SELECT p.profile_id,p.profile_name,p.profile_status,p.profile_gender,p.profile_interest,p.profile_age FROM profiles p WHERE p.profile_status = 0 AND p.profile_gender = 'F'";
	    
	
	@Query(value = FIND_Profile_GENDER , nativeQuery=true)
	public List<Object[]> getByGender();
	
	
    public static final String FIND_AGENT_GENDER1 = "SELECT p.profile_id,p.profile_name,p.profile_status,p.profile_gender,p.profile_interest,p.profile_age FROM profiles p WHERE p.profile_status = 0 AND p.profile_gender = 'M'";
	
	
	@Query(value = FIND_AGENT_GENDER1 , nativeQuery=true)
	public List<Object[]> getByMale();
	
	
	
}

