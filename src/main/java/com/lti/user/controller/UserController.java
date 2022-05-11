package com.lti.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.exception.UserNotFoundException;
import com.lti.model.ForgotPassword;
import com.lti.model.UpdateStatus;
import com.lti.model.UserStatusCount;
import com.lti.opportunity.dao.StatusMangoRepository;
import com.lti.user.Dao.UserMongoRepository;
import com.lti.user.model.Login;
import com.lti.user.model.User;
import com.lti.user.service.UserService;
import com.lti.userAuh.service.UserAuthenticationService;

@RestController
@RequestMapping("/user-app")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserMongoRepository userDao;
	
	@Autowired
	private StatusMangoRepository statusRepo;
	
	
	@Autowired
	
	private UserAuthenticationService userAuthService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login log) throws UserNotFoundException {	
		
		return new ResponseEntity<String>(userAuthService.login(log.getUsername(), log.getPassword()),HttpStatus.OK); 
		
	}
	
	@PostMapping("/loginwithRole")
	public ResponseEntity<?> loginWithRole(@RequestBody Login log) throws UserNotFoundException {	
		
		return new ResponseEntity<String>(userAuthService.loginWithRole(log.getUsername(), log.getPassword(), log.getRole()),HttpStatus.OK); 
		
	}
	
	
	@GetMapping("/getDefaultPwd/{psNumber}")
	public ResponseEntity<?> getDefaultPassword(@PathVariable("psNumber") String psNumber) {
		
		String defultPassword =userAuthService.getDefultPassword(psNumber);
		return new ResponseEntity<String>(defultPassword,HttpStatus.OK); 	
	}
	
	
	@GetMapping("/validatePin/{psNumber}/{pin}")
	public ResponseEntity<?> validatePin(@PathVariable("psNumber") String psNumber,@PathVariable("pin") String pin) {
		
		return new ResponseEntity<Boolean>(userAuthService.validatePin(psNumber, pin),HttpStatus.OK); 	
	}
	
	
	
	@GetMapping("/validiatePwd/{psNumber}")
	public ResponseEntity<?> validatePassword(@PathVariable("psNumber") String psNumber) {
		
		boolean flag =userAuthService.validatePasswords(psNumber);
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK); 	
	}
	
	
	
	
	@PostMapping("/statusUpdateById")
	public ResponseEntity<?> updateStatusById(@RequestBody UpdateStatus status) {
		
		return new ResponseEntity<String>(service.UpdateStatusById(status),HttpStatus.OK); 
		
	}


	@PostMapping("/status")
	public ResponseEntity<?> updateStatus(@RequestBody String status) {
		
		return new ResponseEntity<UserStatusCount>(service.statusUpdate(status),HttpStatus.OK); 
		
	}
	
	
	
	@GetMapping("/findStatus")
	public ResponseEntity<?> getStatus() {
		
		return new ResponseEntity<UserStatusCount>(statusRepo.findById(1).get(),HttpStatus.OK); 	
	}
	
	
	
	@PostMapping("/reset")
	public ResponseEntity<?> resetPassword(@RequestBody ForgotPassword pwd) {
		
		System.out.println("PWD");
		
		return new ResponseEntity<String>(userAuthService.changePassword(pwd.getCurrentPassword(), pwd.getPsnumber(), pwd.getNewPassword()),HttpStatus.OK); 
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {

		System.out.println("Save Controller");
		String response=service.save(user);
		System.out.println("=============Response==="+response);
		
		return response;
					
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<?>getUser(){
		
		List<User>userlist=userDao.findAll();
		return new ResponseEntity<List<User>>(userlist,HttpStatus.OK);
	}

}
