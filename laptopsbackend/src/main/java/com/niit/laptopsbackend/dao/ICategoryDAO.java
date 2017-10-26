package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Category;

public interface ICategoryDAO {
	
	public void saveCategory(Category category);
	public List<Category>getCategories();
	public void delete(Category category);
	public Category get(int id);
	public boolean Update(Category category);

}
