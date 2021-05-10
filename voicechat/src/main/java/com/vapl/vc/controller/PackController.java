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

import com.vapl.vc.model.Pack_Details;
import com.vapl.vc.service.PackDAO;

@RestController
@RequestMapping("/")
public class PackController {
   
	
	@Autowired
	PackDAO packDao;
	
	@PostMapping("/addPackDetails")
	public ResponseEntity<Pack_Details> addPackDetailsData(@RequestBody Pack_Details pack)
	{
		Pack_Details getPack =null;
		try
		{
			getPack = packDao.add_packData(pack);
			return ResponseEntity.of(Optional.of(getPack));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/allpack")
	public ResponseEntity<List<Pack_Details>> getPackData()
	{
		List<Pack_Details> list = packDao.get_packDetails();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
}
