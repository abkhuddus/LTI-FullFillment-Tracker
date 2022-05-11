package com.lti.user.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.user.model.ERole;
import com.lti.user.model.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User,String> {
	

	public User findByPsNumberAndPassword(String psnumber ,String Password);
	
	public User findByPsNumberAndPasswordAndRole(String psNumber,String password,ERole role);

	
	public User findByPsNumber(String psnumber);
	
	  Boolean existsByPsNumber(String psNumber);
	  Boolean existsByEmail(String email);
	  
	  Boolean existsByPin(String pin);
	  
	  User findByPsNumberAndPin(String psNumber,String pin);

}
