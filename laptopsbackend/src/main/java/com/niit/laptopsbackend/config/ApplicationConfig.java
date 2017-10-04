package com.niit.laptopsbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.laptopsbackend.dao.CartDAOImpl;
import com.niit.laptopsbackend.dao.CategoryDAOImpl;
import com.niit.laptopsbackend.dao.ICartDAO;
import com.niit.laptopsbackend.dao.ICategoryDAO;
import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.dao.ISupplierDAO;
import com.niit.laptopsbackend.dao.IUserDAO;
import com.niit.laptopsbackend.dao.ProductDAOImpl;
import com.niit.laptopsbackend.dao.SupplierDAOImpl;
import com.niit.laptopsbackend.dao.UserDAOImpl;
import com.niit.laptopsbackend.model.Cart;
import com.niit.laptopsbackend.model.Category;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.Supplier;
import com.niit.laptopsbackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/sai");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("data source");
		return dataSource;
		
	}
	
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.current_session_context_class","thread");
		System.out.println("hibernate");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		System.out.println("session factory");
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="categoryDAO")
	public ICategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean(name="productDAO")
	public IProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public ISupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="category")
	public Category getCategory()
	{
		return new Category();
	}
	@Autowired
	@Bean(name="product")
	public Product getProduct()
	{
		return new Product();
	}
	
	@Autowired
	@Bean(name="supplier")
	public Supplier getSupplier()
	{
		return new Supplier();
	}
	@Autowired
	@Bean(name="cart")
	public Cart getCart()
	{
		return new Cart();
	}
	@Autowired
	@Bean(name="cartDAO")
	public ICartDAO getCartDAO(SessionFactory sessionFactory)
	{
		return new CartDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDAO")
	public IUserDAO getUserDAO(SessionFactory sessionFactory)
	{
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		return new User();
	}
	
	@Autowired
	@Bean(name="transactionmanager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}

}
