package com.lti.user.util;

import org.springframework.stereotype.Component;

@Component
public class PinKey {
	
	 public static String generateOTP() 
	    {  
		  
		  
		   int randomPin   =(int) (Math.random()*9000)+1000;
	        String otp  = String.valueOf(randomPin);
	        return otp; //returning value of otp
	    }
	 

}
