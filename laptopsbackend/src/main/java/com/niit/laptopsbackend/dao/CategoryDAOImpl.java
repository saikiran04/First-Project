package com.niit.laptopsbackend.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		/*s.clear();*/
		
	}
	@Transactional
	public List<Category> getCategories() {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Category");
		List<Category>cat=query.list();
		Iterator<Category>it=cat.iterator();
		while(it.hasNext())
		{
			Category c=(Category)it.next();
			System.out.println(c.getCategoryname());
		}
		if(cat!=null)
		{
			System.out.println("Here "+cat);
			return cat;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		// TODO Auto-generated method stub
		
	}
	public void delete(Category category) {
		Session s=sessionFactory.getCurrentSession();
		System.out.println("I am in DAO");
		Transaction t=s.beginTransaction();
		s.delete(category);
		t.commit();
		}
		
		/*try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}*/
		
		
		
		
	
	public Category get(int id) {
		
		String hql="from Category where catid="+id;
		Session s=sessionFactory.openSession();
		System.out.println("I am in get");
		Transaction t=s.beginTransaction();
		Query query=s.createQuery(hql);
		List<Category>cate=query.list();
		if(cate==null)
		{
			
			return null;
		
		}
		else
		{
			System.out.println("List empty");
			return cate.get(0);
		}
	}
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from Category where categoryid=:id",Category.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}*/
		
		
	}
	

