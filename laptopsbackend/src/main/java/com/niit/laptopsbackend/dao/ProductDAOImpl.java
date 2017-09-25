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
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.Supplier;
@Repository("productDAO")
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	


	public void saveProduct(Product product) {

		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.save(product);
		t.commit();
		
		
	}




	@Transactional
	public List<Product> list() {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Product");
		List<Product>pro=query.list();
		if(pro!=null)
		{
			System.out.println();
			return pro;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		
	}





	public void delete(Product product) {
		Session s=sessionFactory.getCurrentSession();
		System.out.println("I am in DAO");
		Transaction t=s.beginTransaction();
		s.delete(product);
		t.commit();
		}
		/*try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}*/
	





	public Product get(int id) {
		String hql="from Product where prodid="+id;
		Session s=sessionFactory.openSession();
		System.out.println("I am in get");
		Transaction t=s.beginTransaction();
		Query query=s.createQuery(hql);
		List<Product>prod=query.list();
		if(prod==null)
		{
			
			return null;
		
		}
		else
		{
			System.out.println("List empty");
			return prod.get(0);
		}
	}
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from product where prodid=:id",Product.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}*/
	}


