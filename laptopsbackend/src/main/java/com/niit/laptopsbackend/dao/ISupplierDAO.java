package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.Supplier;

public interface ISupplierDAO {
	
	public boolean saveOrUpdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(int id);
	public List<Supplier> getSuppliers();

}
