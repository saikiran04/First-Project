package com.niit.laptopsbackend;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopsbackend.dao.ICategoryDAO;
import com.niit.laptopsbackend.model.Category;

public class CategoryTest {
	static AnnotationConfigApplicationContext context;
	static ICategoryDAO categoryDAO;
	static Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categoryDAO=(ICategoryDAO)context.getBean("categoryDAO");
		
	}

	@Test
	public void test() {
		category=new Category();
		List<Category>list=categoryDAO.getCategories();
	
		
		Iterator<Category>it=list.iterator();
		while(it.hasNext())
		{
			Category c=(Category)it.next();
			System.out.println(c.getCatid()+" "+c.getCategoryname());
		}
		
	}

}
