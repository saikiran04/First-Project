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
			return pro;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		
	}

}
