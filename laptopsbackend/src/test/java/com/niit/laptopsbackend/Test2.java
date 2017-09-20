package com.niit.laptopsbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
	
	static AnnotationConfigApplicationContext context;
	

	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		System.out.println("Product test");

	}

}
