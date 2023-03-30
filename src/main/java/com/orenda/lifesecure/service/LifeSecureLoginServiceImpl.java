package com.orenda.lifesecure.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Random;
import java.util.Base64.Encoder;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orenda.lifesecure.constants.LifeSecureConstants;
import com.orenda.lifesecure.dao.LifeSecureLoginDao;
import com.orenda.lifesecure.model.ContactUs;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;
import com.orenda.lifesecure.utility.LifeSecureCommonUtility;

@Service

public class LifeSecureLoginServiceImpl implements LifeSecureLoginService {

	@Autowired
	LifeSecureLoginDao loginDao;

	static Cipher cipher;

	static Random random = new Random(1000);
	static LocalTime systemTime = LocalTime.now();
	// login code

	@Override
	public UserDetails verifyUserCredentilas(String username, String password) {

		System.out.println("service");
		User user = loginDao.getUserDetailsByEmailId(username);
		UserDetails userdetails = null;

		if (username != null && user != null && user.getPassword() != null && user.getPassword().equals(password)) {
			try {
				userdetails = loginDao.getUserType(username);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return userdetails;
	}

	public String verifyUserEmail(String emailId, HttpSession session) {
		String verifyUserMsg = "";
		boolean flag = getUserByEmail(emailId);

		if (flag) {
			int otp = random.nextInt(999999);
			LocalTime expiredTime = systemTime.plusMinutes(5);
			System.out.println(otp);
			session.setAttribute("emailId", emailId);
			session.setAttribute("oldotp", otp);
			session.setAttribute("expireTime", expiredTime);

			// we can send email to user
			String msg = "OTP for password reset :" + otp + " vaild For 5 mins";
			String subject = "OTP From secure insurance";
			String form = "parthegaurav@gmail.com";
			String to = emailId;

			flag = LifeSecureCommonUtility.sendEmail(msg, subject, form, to);
			if (flag) {
				verifyUserMsg = LifeSecureConstants.EMAILSENT;
			} else {
				verifyUserMsg = LifeSecureConstants.EMAILNOTSEND;
			}
		} else {
			verifyUserMsg = LifeSecureConstants.EMAILNOTPRESENT;
		}

		return verifyUserMsg;
	}

	// register code

	@Override
	public boolean saveUserDetails(UserDetails userdetails, String password) {

		boolean flag1 = loginDao.saveUserData(userdetails);
		if (flag1) {
			// byte[]passwordEncrypt=encryptPassword(password);
			User user = new User();
			// user.setPassword(passwordEncrypt);
			user.setPassword(password);
			user.setActive(true);
			user.setPasswordValidFrom(LocalDate.now());
			user.setUpdateTime(new Date());
			user.setPasswordValidTill(user.getPasswordValidFrom().plusDays(90));
			user.setEmail(userdetails.getEmail());
			boolean flag = loginDao.saveUsername(user);

			System.out.println(flag);
			return true;
		}

		return false;
	}

	private byte[] encryptPassword(String password) {

		try {
			KeyGenerator key = KeyGenerator.getInstance("AES");
			key.init(128);
			SecretKey secretKey = key.generateKey();

			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] bytePassword = password.getBytes();
			byte[] byteEncrypt = cipher.doFinal(bytePassword);
			Encoder encoder = Base64.getEncoder();
			byte[] encryptedText = encoder.encode(byteEncrypt);
			System.out.println("new hide password" + encryptedText);
			return encryptedText;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// forgot code

	@Override
	public boolean getUserByEmail(String emailId) {

		User user = loginDao.getUserInDb(emailId);
		if (user == null) {
			System.out.println("user is null");
			return false;
		}
		if (user.getEmail().equalsIgnoreCase(emailId)) {
			return true;
		}
		return false;

	}

	@Override
	public boolean verifyOtp(String emailId, String newPassword) {

		// System.out.println("emailId and new password"+emailId+","+newPassword);

		return loginDao.resetPasswordDb(emailId, newPassword);

	}

	@Override
	public boolean saveAndNotifyContactUs(ContactUs contactUs) {
		
		String msg = "Now customer Enquiry Email";
		String subject = "";
		String form = contactUs.getEmail();
		String to = "companyMail";
		
		LifeSecureCommonUtility.sendEmail(msg, msg, form, to);
	//	boolean flag=loginDao.saveContactUs(contactUs);
		return loginDao.saveContactUs(contactUs);
	}

}
