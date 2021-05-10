package com.vapl.vc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vapl.vc.model.Pack_Details;

@Repository
public interface PackRepo extends JpaRepository<Pack_Details, Long> {
   
}
