package com.niit.laptopsbackend;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.model.Product;

public class ProductTest {
	static AnnotationConfigApplicationContext context;
	static IProductDAO productDAO;
	static Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		productDAO=(IProductDAO)context.getBean("productDAO");
		
	}

	@Test
	public void test() {
		product=new Product();
		List<Product>list=productDAO.list();
	
		
		Iterator<Product>it=list.iterator();
		while(it.hasNext())
		{
			Product p=(Product)it.next();
			System.out.println(p.getProdname()+" "+p.getProdid());
		}
		
	}

}
