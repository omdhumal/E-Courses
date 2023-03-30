package com.orenda.lifesecure.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orenda.lifesecure.model.Agent;
import com.orenda.lifesecure.model.CustomerStatus;

@Repository
@Transactional
public class LifeSecureReviewerDaoImpl implements LifeSecureReviewerDao {

	@Autowired
	SessionFactory sessionFactory;

	




	@Override
	public void validateCustomerDb(CustomerStatus cStatus) {
		Session session = sessionFactory.getCurrentSession();
		
		 session.saveOrUpdate(cStatus);
	}



	@Override
	public List<Agent> getAllCustomer(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Agent where userCreatedBy=?");
		List listOfCustomer = query.setParameter(0, username).getResultList();
		System.out.println(listOfCustomer);
		return listOfCustomer;
	
	}
	
	

	
	}

	
	



