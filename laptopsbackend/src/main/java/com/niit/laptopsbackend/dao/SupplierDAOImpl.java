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

	public void delete(Supplier supplier) {
		Session s=sessionFactory.getCurrentSession();
		System.out.println("I am in Supplier DAO");
		Transaction t=s.beginTransaction();
		s.delete(supplier);
		t.commit();
		}
		
		
		/*try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}*/
		
		
	
	@Transactional
	public Supplier get(int id) {
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier where supplierid=:id",Supplier.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}*/
		String hql="from Supplier where supplierid="+id;
		Session s=sessionFactory.openSession();
		System.out.println("I am in supplier get");
		Transaction t=s.beginTransaction();
		Query query=s.createQuery(hql);
		List<Supplier>sup=query.list();
		if(sup==null)
		{
			
			return null;
		
		}
		else
		{
			System.out.println("List empty");
			return sup.get(0);
		}
	}

	public void saveOrUpdate(Supplier supplier) {
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(supplier);
		t.commit();
		}
		// TODO Auto-generated method stub
		
	}


