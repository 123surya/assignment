package com.sapient.football.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastore.service.DataStoreService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins= {"http://localhost:3000"})
public class DataStoreController {

	@Autowired
	private DataStoreService datastoreService;
	
	@GetMapping(path = "collection")
	public ResponseEntity<Object> getCountries(){
		
		return ResponseEntity.ok(datastoreService.getCollections());
		
	}
	

	
}
