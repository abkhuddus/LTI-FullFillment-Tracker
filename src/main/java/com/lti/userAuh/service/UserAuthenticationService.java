package com.lti.userAuh.service;

import com.lti.user.model.ERole;

public interface UserAuthenticationService {
	
	
	public String login(String mailOrPsNumber , String password);
	
	
	public String getDefultPassword(String emaidOrPsNumber);
	
	public String changePassword(String defultpassword ,String psnumber,String newPassword);
	
	
	public boolean validatePasswords(String psNumber);

	
	public String loginWithRole(String psNumber,String password, ERole role);
	
	
	
	public Boolean validatePin(String psNumber,String pin);
	

}
