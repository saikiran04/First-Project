package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Category;

public interface ICategoryDAO {
	
	public void saveCategory(Category category);
	public List<Category>getCategories();
	public boolean delete(Category category);
	public Category get(int id);

}
