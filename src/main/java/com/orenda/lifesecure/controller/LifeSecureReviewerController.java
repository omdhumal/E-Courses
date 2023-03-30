package com.orenda.lifesecure.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.CustomerStatus;
import com.orenda.lifesecure.service.LifeSecureReviewerService;

@Controller
@RequestMapping("/reviewer")
public class LifeSecureReviewerController {
	@Autowired
	LifeSecureReviewerService reviewerService;
	
	
	@GetMapping("/approve")
	public void verifyCustomer(@RequestParam("id")int id,@RequestParam("status")String status) {
		System.out.println("the customer id"+id);
		CustomerStatus cStatus=new CustomerStatus();
		
		if(status.equalsIgnoreCase("approve")) {
			cStatus.setId(id);
			cStatus.setStatus("approve");
			cStatus.setApproveDate(new Date());
			reviewerService.validateCustomer( cStatus);
		}
		
		
	}

}
