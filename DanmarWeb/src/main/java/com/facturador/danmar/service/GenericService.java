package com.facturador.danmar.service;

import java.util.List;

import com.danmar.error.ErrorRespuestaBean;


public interface GenericService<E> {

	ErrorRespuestaBean save(E dto);
	
	public List<E> getAll();
	
	public E findById(int id);

	ErrorRespuestaBean saveOrUpdate(E dto);
	

}
