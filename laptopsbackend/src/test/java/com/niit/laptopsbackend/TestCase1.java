package com.niit.laptopsbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.model.Product;

public class TestCase1 {
	
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
		/*fail("Not yet implemented");*/
		product=new Product();
		product.setProdname("dell");
		product.setPrice(50000);
		product.setQuantity(2);
		productDAO.saveProduct(product);
		assertEquals("inserted",true);
	}

}
