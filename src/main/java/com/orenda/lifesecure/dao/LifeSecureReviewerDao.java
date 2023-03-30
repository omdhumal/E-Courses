package com.orenda.lifesecure.dao;

import java.util.List;

import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.CustomerStatus;
import com.orenda.lifesecure.model.User;

public interface LifeSecureReviewerDao {

	

	

	void validateCustomerDb(CustomerStatus cStatus);

	List<Agent> getAllCustomer(String username);

	




	

}
