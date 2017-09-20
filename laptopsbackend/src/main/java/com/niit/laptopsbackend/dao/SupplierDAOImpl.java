package com.niit.laptopsbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.laptopsbackend.model.Category;
import com.niit.laptopsbackend.model.Supplier;
import com.niit.laptopsbackend.model.User;

@Repository("supplierDAO")
public class SupplierDAOImpl implements ISupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
		
	

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public List<Supplier> getSuppliers() {
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Supplier");
		List<Supplier>sup=query.list();
		if(sup!=null)
		{
			return sup;
		
		}
		else
		{
			System.out.println("List empty");
			return null;
		}
		
		
	}

	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}

	public Supplier get(int id) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from supplier where supplierid=:id",Supplier.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	public boolean saveOrUpdate(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		// TODO Auto-generated method stub
		
	}

}
