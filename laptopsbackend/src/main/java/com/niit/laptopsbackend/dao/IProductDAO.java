package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.Supplier;

public interface IProductDAO {

	public void saveProduct(Product product);
	public List<Product> list();
	public void delete(Product product);
	public Product get(int id);
}
