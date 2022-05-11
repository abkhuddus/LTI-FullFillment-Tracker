package com.lti.user.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lti.user.model.ERole;
import com.lti.user.model.Role;
@Repository
public interface RoleRepository extends MongoRepository<Role,String>{

	
	  Role findByName(ERole name);

}
