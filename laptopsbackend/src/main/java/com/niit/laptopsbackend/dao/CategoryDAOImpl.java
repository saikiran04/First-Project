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
import com.niit.laptopsbackend.model.Supplier;

@Repository("categoryDAO")
public class CategoryDAOImpl implements ICategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void saveCategory(Category category)
	{
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(category);
		t.commit();
		s.clear();
		
	}
	@Transactional
	public List<Category> getCategories() {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Category");
		List<Category>cat=query.list();
		if(cat!=null)
		{
			return cat;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		// TODO Auto-generated method stub
		
	}
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	public Category get(int id) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Category where supplierid=:id",Category.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		
	}
	
}
