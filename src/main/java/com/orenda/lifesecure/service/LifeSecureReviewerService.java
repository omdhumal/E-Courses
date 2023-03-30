package com.orenda.lifesecure.service;

import java.util.List;

import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.CustomerStatus;
import com.orenda.lifesecure.model.User;

public interface LifeSecureReviewerService {

	

	

	void validateCustomer(CustomerStatus cStatus);


	List<Agent> getAllCustomerList(String username);



}
