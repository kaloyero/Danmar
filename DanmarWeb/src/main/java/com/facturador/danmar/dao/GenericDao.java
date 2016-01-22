package com.facturador.danmar.dao;

import java.util.List;

public interface GenericDao<E> {

	public void save(E ent);
	
	public void saveOrUpdate(E ent);
	
	public List<E> getAll();
	
	public E findById(int id);

}