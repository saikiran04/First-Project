package com.niit.laptopsbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopsbackend.model.Category;
import com.niit.laptopsbackend.model.User;
@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
	}

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
		String hql="from User where emailid='"+email+"'";
		Session s=sessionFactory.openSession();
		System.out.println("I am in get");
		Transaction t=s.beginTransaction();
		Query query=s.createQuery(hql);
		List<User>us=query.list();
		if(us==null)
		{
			System.out.println("List empty");
			return null;
		
		}
		else
		{
			for(User u:us)
			{
				System.out.println(u.getEmailid());
				System.out.println(u.getFirstname());
			}
			
			return us.get(0);
		}
		

		/*try {
			return sessionFactory.openSession().createQuery("from User where emailid=:email",User.class).setParameter("email", email).getSingleResult();
		
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
*/
		
	}

	/*@SuppressWarnings("rawtypes")*/
	@Transactional
	public List<User> getAllUsers() {

		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From User");
		List<User>us=query.list();
		tx.commit();
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

	public User getbyid(int id) {
		String hql="from User where userid="+id;
		Session s=sessionFactory.openSession();
		System.out.println("I am in get");
		Transaction t=s.beginTransaction();
		Query query=s.createQuery(hql);
		List<User>us=query.list();
		if(us==null)
		{
			
			return null;
		
		}
		else
		{
			System.out.println("List empty");
			return us.get(0);
		}
	}

}
