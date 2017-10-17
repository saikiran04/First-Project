package com.niit.laptopsbackend;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopsbackend.dao.ISupplierDAO;
import com.niit.laptopsbackend.model.Supplier;

public class SupplierTest {
	static AnnotationConfigApplicationContext context;
	static ISupplierDAO supplierDAO;
	static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDAO=(ISupplierDAO)context.getBean("supplierDAO");
		
	}

	@Test
	public void test() {
		supplier=new Supplier();
		List<Supplier>list=supplierDAO.getSuppliers();
	
		
		Iterator<Supplier>it=list.iterator();
		while(it.hasNext())
		{
			Supplier s=(Supplier)it.next();
			System.out.println(s.getSuppliername()+" "+s.getEmail());
		}
		
	}

}
