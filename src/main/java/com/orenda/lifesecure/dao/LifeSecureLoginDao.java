package com.orenda.lifesecure.dao;

import com.orenda.lifesecure.model.ContactUs;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

public interface LifeSecureLoginDao {

	User getUserInDb(String emailId);
	
	boolean resetPasswordDb(String emailId, String newPassword);

	User getUserDetailsByEmailId(String username);

	UserDetails getUserType(String username);

	User verifyUser(String useremail);

	boolean saveUserData(UserDetails userdetails);

	boolean saveUsername(User user);

	boolean saveContactUs(ContactUs contactUs);
	
	

}
