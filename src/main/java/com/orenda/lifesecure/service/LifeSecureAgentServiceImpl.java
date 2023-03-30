package com.orenda.lifesecure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orenda.lifesecure.dao.LifeSecureAgentDao;
import com.orenda.lifesecure.dao.LifeSecureLoginDao;
import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.User;

@Service
public class LifeSecureAgentServiceImpl implements LifeSecureAgentService {

	@Autowired
	LifeSecureAgentDao agentDao;

	

	@Override
	public List<Agent> getAllCustomer(String userEmail) {
		
		
		List<Agent> listOfCustomer=agentDao.getAllCustomer(userEmail);
		
		
		
		return listOfCustomer;
	}



	

	



}
