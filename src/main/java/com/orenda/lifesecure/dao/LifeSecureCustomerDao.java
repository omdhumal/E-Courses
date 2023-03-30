package com.orenda.lifesecure.dao;

import java.util.List;

import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.UserDetails;

public interface LifeSecureCustomerDao {

	// UserDetails getCustomer();

	PolicyDetails getPolicyDetails(int customerId);

	UserDetails editUserRecord(int userId);

	List<TransactionHistory> getAllTransactionList(int customerId);

}
