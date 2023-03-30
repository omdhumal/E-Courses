package com.orenda.lifesecure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.service.LifeSecureAgentService;

@Controller
@RequestMapping("/agent")
public class LifeSecureAgentController {
	@Autowired
	LifeSecureAgentService agentService;
	
//	@GetMapping("/getEmpList")
//	public String getCustomerList(Model model) {
//		
//		List<Agent> userList = agentService.getAllEmpList();
//		System.out.println(userList.toString());
//		model.addAttribute("uList", userList);
//		return "agent";
//	}
//	

}
