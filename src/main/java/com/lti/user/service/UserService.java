package com.lti.user.service;

import org.springframework.stereotype.Service;

import com.lti.exception.UserNotFoundException;
import com.lti.model.ForgotPassword;
import com.lti.model.UpdateStatus;
import com.lti.model.UserStatusCount;
import com.lti.user.model.Login;
import com.lti.user.model.User;

@Service
public interface UserService {

	public String save(User user);
	
	public String login(Login login) throws UserNotFoundException;
	
	
	public UserStatusCount statusUpdate(String status);
	
	
	//public String SaveOpportunity(Opportunity op);
	
	
	//public List<Opportunity>getAllOpportunity();
	
//	public List<OpStatusDTO> getOpBasedOnStatus();
	
	
	//public List<Opportunity> getOPPById(Integer id);
	
	
	public String UpdateStatusById(UpdateStatus s);

}
