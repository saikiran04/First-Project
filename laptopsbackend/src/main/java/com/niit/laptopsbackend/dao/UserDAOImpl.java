package com.niit.laptopsbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptopsbackend.model.User;
@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user) {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(user);
		tx.commit();
		return false;
	}

	public boolean deleteUser(User user) {


		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		s.delete(user);
		System.out.println("Deleted Succesfully");
		tx.commit();
		s.close();
		return false;
	}

	public User get(String email) {

		try {
			return sessionFactory.openSession().createQuery("from User where emailid=:email",User.class).setParameter("eamil", email).getSingleResult();
		
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}

		
	}

	@SuppressWarnings("rawtypes")
	public List<User> getAllUsers() {

		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From User");
		List<User>us=query.list();
		if(us!=null)
		{
			return us;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		
	}

}
