package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Supplier;

public interface ISupplierDAO {
	
	public void saveOrUpdate(Supplier supplier);
	public void delete(Supplier supplier);
	public Supplier get(int id);
	public List<Supplier> getSuppliers();

}
