package com.lti.userAuh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.user.Dao.UserMongoRepository;
import com.lti.user.model.ERole;
import com.lti.user.model.User;
import com.lti.userAuh.service.UserAuthenticationService;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	
	@Autowired
	
	private UserMongoRepository userDao;
	
	
	@Override
	public String login(String psNumber, String password) {
			
			try {
				if(psNumber ==null ||password ==null) 
					return "Please Enter Email And PassWord";
				
				User user= userDao.findByPsNumberAndPassword( psNumber, password);
				
				if(user!=null) {
					return "Welcome "+" "+user.getLastname();
				}else {
					return "Login Failed";
				}
			} catch (Exception e) {
			e.getMessage();
			}
		
		return null;
	}


	@Override
	public String getDefultPassword(String PsNumber) {
		
			try {
				if(PsNumber==null) 
					return "Please Enter Email Or PSNumber";
				
				User user=userDao.findByPsNumber(PsNumber);
				
				if(user!=null) {
					 user.setPassword(user.getDefaultPassword());
					 userDao.save(user);
					return "Your Defult Password is"+" "+user.getDefaultPassword()+", "+"Your Password Succesfully Reset as"+" "+user.getPassword();
				}else {
					return "Something Went Wrong";
				}

			} catch (Exception e) {

			
			}
		
		return null;
	}


	@Override
	public String changePassword(String defultpassword, String psnumber,String newPassword) {
		
		
		try {
			if(defultpassword!=null && psnumber!=null && newPassword!=null) {
				User user=userDao.findByPsNumberAndPassword(psnumber, defultpassword);
				if(user==null) {
					return "Please Enter Valid PsNumber And password";
				}
				else {
					user.setPassword(newPassword);
					userDao.save(user);
					
					return "Your password Successfully Reset as"+" "+newPassword;
					
				}		
			}else {
				return "Please Enter Valid PsNumber And password";

			}
			
		} catch (Exception e) {
	}
		return null;
		
		
	}


	@Override
	public boolean validatePasswords(String psNumber) {
		
		
		  if(psNumber !=null) {
			User user=  userDao.findByPsNumber(psNumber);
			
			if(user!=null) {
				
				if(user.getDefaultPassword().equals(user.getPassword())) {
					
					return true;
				}else {
					
					return false;
				}
			}
		  }
		
		return false;
	}


	@Override
	public String loginWithRole(String psNumber, String password, ERole role) {
		try {
			User user=userDao.findByPsNumberAndPasswordAndRole(psNumber, password, role);
			
			if(user!=null) {
				return "Welcome" + " "+ user.getLastname();
			}
			else {
				return "Login Failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public Boolean validatePin(String psNumber, String pin) {
		
		boolean flag=false;
		
		User user=userDao.findByPsNumberAndPin(psNumber, pin);
		if(user!=null) {
			flag=true;
		}
		return flag;
	}


	
	
	
	

}
