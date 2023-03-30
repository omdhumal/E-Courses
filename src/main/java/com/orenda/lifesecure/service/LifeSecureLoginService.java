package com.orenda.lifesecure.service;

import javax.servlet.http.HttpSession;

import com.orenda.lifesecure.model.ContactUs;
import com.orenda.lifesecure.model.UserDetails;

public interface LifeSecureLoginService {

	boolean getUserByEmail(String emailId);
	
    boolean verifyOtp(String emailId, String newPassword);


	UserDetails verifyUserCredentilas(String username, String password);

	boolean saveUserDetails(UserDetails userdetails,String password);

	String verifyUserEmail(String emailId, HttpSession session);

	boolean saveAndNotifyContactUs(ContactUs contactUs);

	

}
