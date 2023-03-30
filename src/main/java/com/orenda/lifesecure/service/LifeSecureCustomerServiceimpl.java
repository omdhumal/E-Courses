package com.orenda.lifesecure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orenda.lifesecure.dao.LifeSecureCustomerDao;
import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

@Service
public class LifeSecureCustomerServiceimpl implements LifeSecureCustomerService {
    
	@Autowired
	LifeSecureCustomerDao loginCustomerDao;
	
	
//	@Override
//	public UserDetails getCustomer() {
//		
//		return loginCustomerDao.getCustomer();
//	}
	@Override
	public PolicyDetails getPolicyDetails(int customerId) {
		
		return loginCustomerDao.getPolicyDetails(customerId);
	}


	@Override
	public List<TransactionHistory> getAllTransactionList(int customerId) {
	
		return loginCustomerDao.getAllTransactionList(customerId);
	}
	
	
	@Override
	public UserDetails editUserDetailsById(int userId) {
		
		return loginCustomerDao.editUserRecord(userId);
	}

	


	
}
