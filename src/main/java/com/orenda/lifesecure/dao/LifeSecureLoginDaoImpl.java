package com.orenda.lifesecure.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orenda.lifesecure.model.ContactUs;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

@Repository
@Transactional
public class LifeSecureLoginDaoImpl implements LifeSecureLoginDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserDetailsByEmailId(String username) {

		Session session = sessionFactory.openSession();
		User user = null;
		try {

		Query query = session.createQuery(" from User where email=?");
		user = (User) query.setParameter(0, username).getSingleResult();
		} catch (Exception e) {

		}
//		
		return user;
	}

	@Override
	public UserDetails getUserType(String username) {
		Session session = sessionFactory.openSession();
		UserDetails userdetails=null;
		
			
		Query query = session.createQuery("from UserDetails  where email=?");
		 userdetails = (UserDetails) query.setParameter(0, username).getSingleResult();
		
	//	System.out.println("hello"+userdetails.toString());
		
		return userdetails;
	}

	public List<UserDetails> getData() {
		Session session = sessionFactory.openSession();
		List <UserDetails>userList=null;
		try {
		
		  userList = session.createCriteria(UserDetails.class).list();
		}catch(Exception e) {
			
		}
		return userList;

	}
	//register code
	
	@Override
	public User verifyUser(String useremail) {
		System.out.println("daoo" + useremail);
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User where email=?");

		User user = (User) query.setParameter(0, useremail).getSingleResult();

		System.out.println(user.toString());

		return user;
	}
	
	@Override
	public boolean saveUsername(User user) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		try {
			//session.save(user);
			//session.persist(user);
			session.saveOrUpdate(user);
			tr.commit();
			return true;
			
			}catch(Exception e) {
				e.printStackTrace();
				tr.rollback();
				session.close();
				return false;
			}
			
		
	}
	
	

	@Override
	public boolean saveUserData(UserDetails userdetails) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		try {
		//session.save(user);
		//session.persist(user);
		session.saveOrUpdate(userdetails);
		tr.commit();
		return true;
		
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
			session.close();
			return false;
		}
		
	}
	
	//forgot code

	@Override
	public User getUserInDb(String emailId) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery("from User where user_email=?");

			user = (User) query.setParameter(0, emailId).getSingleResult();
		} catch (Exception e) {

		}
		return user;
	}

	@Override
	public boolean resetPasswordDb(String emailId, String newPassword) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User where user_email=?");
			

			User user = (User) query.setParameter(0, emailId).getSingleResult();
		//	user.setPassword(newPassword);

			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(user);
			tr.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean saveContactUs(ContactUs contactUs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(contactUs);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
