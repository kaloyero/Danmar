package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.error.ErrorRespuestaBean;


public interface GenericManager<F> {

	ErrorRespuestaBean save(F form);
	
	public List<F> getAll();

	public F findById(int id);

	ErrorRespuestaBean saveOrUpdate(F form);
}
