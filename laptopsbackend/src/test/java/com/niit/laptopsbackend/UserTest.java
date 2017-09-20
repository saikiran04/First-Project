package com.niit.laptopsbackend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.laptopsbackend.dao.IUserDAO;
import com.niit.laptopsbackend.model.User;

public class UserTest {
	 
	static AnnotationConfigApplicationContext context;
	static IUserDAO userDAO;
	static User user;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		userDAO=(IUserDAO)context.getBean("userDAO");
		
	}

	@Test
	public void test() {
		user=new User();
		List<User>list=userDAO.getAllUsers();
	
		/*user.setFirstname("sai");
		user.setLastname("A");
		user.setUsername("saikiran");
		user.setEmailId("s@gmail.com");
		user.setMobile(987654321);
		user.setPassword("saikiran");
		user.setRole("ROLE_USER");
		assertEquals("inserted",true,userDAO.addUser(user));*/
		Iterator<User>it=list.iterator();
		while(it.hasNext())
		{
			User u=(User)it.next();
			System.out.println(u.getFirstname()+" "+u.getLastname());
		}
		
	}

}
