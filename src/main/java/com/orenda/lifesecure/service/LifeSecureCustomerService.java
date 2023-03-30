package com.orenda.lifesecure.service;


import java.util.List;

import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

public interface LifeSecureCustomerService {

	//UserDetails getCustomer();

	PolicyDetails getPolicyDetails(int customerId);
	
	UserDetails editUserDetailsById(int userId);

	List<TransactionHistory> getAllTransactionList(int customerId);

	

	

}
