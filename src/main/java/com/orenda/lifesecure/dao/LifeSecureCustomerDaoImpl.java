package com.orenda.lifesecure.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orenda.lifesecure.model.PolicyDetails;
import com.orenda.lifesecure.model.TransactionHistory;
import com.orenda.lifesecure.model.UserDetails;

@Repository
public class LifeSecureCustomerDaoImpl implements LifeSecureCustomerDao {

	@Autowired
	SessionFactory sessionFactory;

//	@Override
//	public UserDetails getCustomer() {
//
//		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from UserDetails where email=?");
//		UserDetails customer = (UserDetails) query.setParameter(0, "amit@gmail.com").getSingleResult();
//
//		return customer;
//
//	}

	@Override
	public PolicyDetails getPolicyDetails(int customerId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PolicyDetails where customerId=?");
		PolicyDetails policyDetails = (PolicyDetails) query.setParameter(0, customerId).getSingleResult();
		return policyDetails;
		
		
	}



	@Override
	public List<TransactionHistory> getAllTransactionList(int customerId) {

		Session session = sessionFactory.openSession();
		
		 List transaction = session.createQuery("from TransactionHistory where customerId=?").setParameter(0, customerId).getResultList();

		//List<TransactionHistory> transaction = session.createCriteria(TransactionHistory.class).list();

		return transaction;
	}
	
	
	

@Override
public UserDetails editUserRecord(int userId) {
	Session session = sessionFactory.getCurrentSession();
	UserDetails customer = session.get(UserDetails.class, userId);
	return customer;
}
}