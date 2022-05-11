package com.lti.user.serviceimpl;


import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.exception.UserNotFoundException;
import com.lti.model.UpdateStatus;
import com.lti.model.UserStatusCount;
import com.lti.user.Dao.UserMongoRepository;
import com.lti.user.model.Login;
import com.lti.user.model.User;
import com.lti.user.service.UserService;
import com.lti.user.util.PinKey;
import com.lti.user.util.ReferralCode;
import com.lti.user.util.ReferralConfig;
import com.lti.user.util.SequenceIdGenerator;
@Service
public class UserServiceImpl implements UserService {

	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	 @Autowired
	    private SequenceIdGenerator sequenceId;
	 
	@Autowired
	private UserMongoRepository userDao;
	
  
	
  	
	@Override
	public String save(User user) {
		logger.info("Entered Into user Save Method ");
		
		try {
			if(user!=null) {
			
				User existUser=userDao.findByPsNumber(user.getPsNumber());
				if(existUser!=null) 
					return "user is Present";
				
		        user.setId(Long.toString(sequenceId.nextId()));
		        
		        ReferralConfig config1 = ReferralConfig.length(8);
		        String defultPassword = ReferralCode.generate(config1);
		         
		        user.setDefaultPassword(defultPassword);
		        user.setPassword(user.getDefaultPassword());
		        
		        user.setRole(user.getRole());
				
		         
		         
		         String genretePIn=PinKey.generateOTP();
		          Boolean checkPin=false;
		          checkPin=userDao.existsByPin(genretePIn);

		          if(checkPin==true) {
			          checkPin=userDao.existsByPin(genretePIn);
		          }
		          checkPin=userDao.existsByPin(genretePIn);
                   if(checkPin==false) {
     		          user.setPin(genretePIn);
                   }
  		         User	u=userDao.save(user);

				if(u!=null) {
				
					return u.getFirstname()+" "+"SuccessFully Added To Database";
				}else {
					
					return "User Not Stored in Database";
				}
			}	
		} catch (Exception e) {
         logger.error("Error while Saving User");
		}
		return null;
	}



	@Override
	public String login(Login login) throws UserNotFoundException {
		 
		logger.info("Entered into Login Method");
		try {
			if(login!=null) {
				User u=userDao.findByPsNumberAndPassword(login.getUsername(), login.getPassword());
		         
				if(u!=null) {
					return "Login SuccessFull"+" "+"Welcome"+" "+u.getFirstname();
				}else {
					throw new UserNotFoundException("Product Not Founds");
				}
			}
			
		} catch (Exception e) {
			logger.error("Exception Occure While Login");
		}
		return null;
	}



	



	

	@Override
	public String UpdateStatusById(UpdateStatus s) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserStatusCount statusUpdate(String status) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	 static char[] OTP(int len)
	    {
	        System.out.println("Generating OTP using random() : ");
	        System.out.print("You OTP is : ");
	  
	        // Using numeric values
	        String numbers = "0123456789";
	  
	        // Using random method
	        Random rndm_method = new Random();
	  
	        char[] otp = new char[len];
	  
	        for (int i = 0; i < len; i++)
	        {
	            // Use of charAt() method : to get character value
	            // Use of nextInt() as it is scanning the value as int
	            otp[i] =
	             numbers.charAt(rndm_method.nextInt(numbers.length()));
	        }
	        return otp;
	    }
	    






	


	

	}
