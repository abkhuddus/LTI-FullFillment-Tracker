package com.lti.opportunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.exception.InvalidRequestException;
import com.lti.model.OpStatusDTO;
import com.lti.opportunity.model.OpportunityDTO;
import com.lti.opportunity.model.OpportunityResponseDTO;
import com.lti.opportunity.model.OpprunitySaveDTO;
import com.lti.opportunity.model.UpdateOpportunityDTO;
import com.lti.opportunity.service.OpportunityService;

@RestController
@RequestMapping("/opportunity")
@CrossOrigin(origins = "http://localhost:4200")

public class OpportunityController {

	@Autowired
	private OpportunityService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveOp(@RequestBody OpprunitySaveDTO op) throws InvalidRequestException {
		if(op!=null) {
			return new ResponseEntity<String>(service.SaveOpportunity(op),HttpStatus.OK); 	
		}
		return null;
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody UpdateOpportunityDTO dto){
		
	String  msg=service.update(dto);
	
	if(msg!=null) {
		return new ResponseEntity<String>(msg,HttpStatus.OK); 	
	}
	return null;
		
	}
	
	
	@GetMapping("/getAllOp")
	public ResponseEntity<?> getAllOpportunity() throws InvalidRequestException {
		
		return new ResponseEntity<List<OpportunityResponseDTO>>(service.getAllOpportunity(),HttpStatus.OK); 
		
	}
	

	@GetMapping("/findByRRNumber/{rrNumber}")
	public ResponseEntity<?> getByRRNumbers(@PathVariable("rrNumber") float rrNumber) {
		return new ResponseEntity<OpportunityResponseDTO>(service.getByRRNumber(rrNumber),HttpStatus.OK); 
		
	}
	
	@GetMapping("/findByOpportunityId/{id}")
	public ResponseEntity<?> getByOpprtuntityID(@PathVariable("id") String id) {
		return new ResponseEntity<List<OpportunityResponseDTO>>(service.getByOpportunityId(id),HttpStatus.OK); 

	}
	
	@GetMapping("/getOpportunityId/{id}")
	public ResponseEntity<?> getByyOpprtuntityID(@PathVariable("id") String id) {
		return new ResponseEntity<OpportunityDTO>(service.getOpportunity(id),HttpStatus.OK); 

	}
	
	@GetMapping("/getYTJ")
	public ResponseEntity<?> getYtj() throws InvalidRequestException {
		return new ResponseEntity<List<OpportunityResponseDTO>>(service.getallYTJ(),HttpStatus.OK); 

	}
	
	@GetMapping("/getStatus")
	public ResponseEntity<?> getOpByStatus() {
		
		return new ResponseEntity<List<OpStatusDTO>>(service.getOpBasedOnStatus(),HttpStatus.OK); 
		
	}
}
