package com.orenda.lifesecure.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.orenda.lifesecure.constants.LifeSecureConstants;
import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.ContactUs;
import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.UserDetails;
import com.orenda.lifesecure.service.LifeSecureAgentService;
import com.orenda.lifesecure.service.LifeSecureCustomerService;
import com.orenda.lifesecure.service.LifeSecureLoginService;
import com.orenda.lifesecure.service.LifeSecureReviewerService;

@Controller
@RequestMapping("/login")
@SessionAttributes
public class LifeSecureLoginController {

	@Autowired
	LifeSecureLoginService loginService;
	
	@Autowired
	LifeSecureAgentService agentService;
	
	@Autowired
	LifeSecureCustomerService customerService;
	@Autowired
	LifeSecureReviewerService reviewerService;

    //login code
    
	@GetMapping("/")
	public String loginPage(Model model) {
		
		model.addAttribute("contactUs",new ContactUs());

		return "login";
	}
	
	@GetMapping("/verifyUser")
	public ModelAndView verifyUser(@RequestParam("username") String username, @RequestParam("password") String password,
			 HttpSession session) {
		System.out.println("login method called::: username::" + username + "  password:: " + password);
		

		 UserDetails userdetails = loginService.verifyUserCredentilas(username, password);
		 
		 ModelAndView model=null;
		 if(userdetails==null) {
			 model=new ModelAndView("login", "msg","Please Enter Correct username or password Please Try Again To Login");
			 return model;
		 }

		if (userdetails.getUsertype().equalsIgnoreCase(LifeSecureConstants.ADMIN)) {
			System.out.println(" admin login sucess");
			model=new ModelAndView("admin");
			return model;
		} else if (userdetails.getUsertype().equalsIgnoreCase(LifeSecureConstants.CUSTOMER)) {
			System.out.println("customer login success #####");
			
			
			List<Object> listOfObjects = populateCustomerData(customerService,userdetails.getId());
			listOfObjects.add(userdetails);
		//	System.out.println("############ "+listOfObjects.toString());
			model=new ModelAndView("customer","listOfObjects",listOfObjects);
			return model;

		} else if (userdetails.getUsertype().equalsIgnoreCase(LifeSecureConstants.AGENT)) {
			System.out.println("agent login success");
			
			List<Agent> customerList = agentService.getAllCustomer(username);
			model=new ModelAndView("agent","uList",customerList);
			return model;

		}else if(userdetails.getUsertype().equalsIgnoreCase("reviewer")) {
			
			List<Agent> listOfCustomer = reviewerService.getAllCustomerList(username);
			System.out.println(listOfCustomer.toString());
			model=new ModelAndView("reviewer","uList",listOfCustomer);
			return model;
			
		}

		else {
			System.out.println("your password or username is incorrect");
		}

		return model;

	}
	
	
	private List<Object> populateCustomerData(LifeSecureCustomerService customerService,int customerId) {
		
		List<Object> listOfObject = new ArrayList<Object>();
		
		PolicyDetails policyDetails = customerService.getPolicyDetails(customerId);
		listOfObject.add(policyDetails);
		
		List<TransactionHistory> transactionHistory = customerService.getAllTransactionList(customerId);
		listOfObject.add(transactionHistory);
		return listOfObject;
	}
	
	//register code
	
	@GetMapping("/register")
	public ModelAndView registerPage() {
		System.out.println("registerpage () :::");
		ModelAndView model = null;
			 model =  new ModelAndView("registration", "userdetails", new UserDetails());
		return model;
	}
	
	
	@PostMapping("/save")
	public String saveUserDetails(@ModelAttribute("userModel") UserDetails userdetails,Model model ,@RequestParam("password")String password, MultipartFile[] fileUpload) throws IOException {
		System.out.println("password::"+password);
		System.out.println("userdetails:: "+userdetails.toString());
		
		

		
		if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: ");
                 
                UserDetails userDetails = new UserDetails();
                //uploadFile.setFileName(aFile.getOriginalFilename());
                userDetails.setImage(aFile.getBytes());
                              
            }
        }
        
		
		boolean flag = loginService.saveUserDetails(userdetails,password);
//		if(userdetails.getId() > 0) {
//			return "login";
//		}
		
		if(flag) {
			 
			 model.addAttribute("message", "User data saved successfully!,please login");
			 return "login";
		}else {
			
			model.addAttribute("userdetails", userdetails);
			 model.addAttribute("message", "User data not saved successfully!,please try again");
			 return "registration";
		} 		   
			}
	
	
	
	//forgot password code

	@GetMapping("/forgot")
	public String forgotPassword() {
		return "forgotPassword";
	}

	@GetMapping("/verifyusername")
	public ModelAndView verifyUserEmail(@RequestParam("email") String emailId, HttpSession session) {

		ModelAndView model = null;

		String userMsg = loginService.verifyUserEmail(emailId, session);
		
		if (userMsg.equals(LifeSecureConstants.EMAILSENT)) {
			model = new ModelAndView("verifyotp");
			return model;
		}else if(userMsg.equals(LifeSecureConstants.EMAILNOTPRESENT)) {
			model = new ModelAndView("login", "msg", "you are not registered user");
			return model;
		}
			
			model = new ModelAndView("login", "msg", "Email could not sent due to some network issue");
			return model;
		
		
	}

	

	

	@PostMapping("/verifyotp")
	public ModelAndView verifyOTP(@RequestParam("otp") int otp, HttpServletRequest request) {
        
		ModelAndView model = null;
		HttpSession session = request.getSession(false);
		int oldotp = (int) session.getAttribute("oldotp");
		LocalTime expiredTime = (LocalTime) session.getAttribute("expiredTime");
		LocalTime userTime = LocalTime.now();
		 

		System.out.println("the old otp is session:" + oldotp);
		

		// verify the otp
		if (otp == oldotp &&userTime.isBefore(expiredTime)) {
			model = new ModelAndView("saveNewPassword", "msg", "OTP is correct");
			return model;
		} else {
			model = new ModelAndView("verifyotp", "msg", "OTP is wrong or Expired");
			return model;
		}

	}

	@PostMapping("savepassword")
	public ModelAndView saveNewPassword(@RequestParam("newPassword") String newPassword, HttpServletRequest request) {

		//System.out.println(newPassword);
		ModelAndView model = null;
		HttpSession session = request.getSession(false);
		String emailId = (String) session.getAttribute("emailId");
		

		boolean flag = loginService.verifyOtp(emailId, newPassword);

		if (flag) {
			System.out.println("password saved successfully");
			model = new ModelAndView("login", "msg", "password is Successfully reset");
			return model;
		}
		return model = new ModelAndView("login", "msg", "please try again..");
	}
	
	@PostMapping("/contactUs")
	public String  contactUs(@ModelAttribute ("contactUs")ContactUs contactUs) {
		
		System.out.println(contactUs.toString());
		loginService.saveAndNotifyContactUs(contactUs);
		return "login";
	}

}
