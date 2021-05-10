package com.vapl.vc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vapl.vc.model.Agents;
import com.vapl.vc.model.Pack_Details;
import com.vapl.vc.repository.PackRepo;

@Service
public class PackDAO {
	
	
	@Autowired
	PackRepo repo;
	
	
	public Pack_Details add_packData(Pack_Details pack)
	{
		return repo.save(pack);
	}
	
	public List<Pack_Details> get_packDetails()
	{
		List<Pack_Details> l = new ArrayList<>();
	   	 repo.findAll().forEach(s -> l.add(s));
	   	 return l;
	}
	

}
