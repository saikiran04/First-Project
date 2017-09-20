package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Product;

public interface IProductDAO {

	public void saveProduct(Product product);
	public List<Product> list();
}
