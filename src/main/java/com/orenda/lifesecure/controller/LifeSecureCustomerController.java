package com.orenda.lifesecure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.UserDetails;
import com.orenda.lifesecure.service.LifeSecureCustomerService;

@Controller
@RequestMapping("/customer")
public class LifeSecureCustomerController {
	@Autowired
	LifeSecureCustomerService loginService;

	@GetMapping("/getCustomerList")
	public String getEmpList(Model model) {

//		UserDetails customerDetails = loginService.getCustomer();
//		System.out.println(customerDetails.toString());
//		
//		model.addAttribute("userList", customerDetails);

		PolicyDetails policyDetails = loginService.getPolicyDetails(0);
		System.out.println(policyDetails.toString());
		model.addAttribute("policyDetails", policyDetails);

		List<TransactionHistory> transactionHistory = loginService.getAllTransactionList(0);
		System.out.println(transactionHistory.toString());
		model.addAttribute("transactionHistory", transactionHistory);

		return "customer";

	}

	@GetMapping("/edit")
	public ModelAndView editUserRecord(@RequestParam("userId") int userId) {
		System.out.println("id " + userId);
		UserDetails customer = loginService.editUserDetailsById(userId);

		ModelAndView model = null;
		model = new ModelAndView("customer", "userList", customer);

		return model;
	}
}