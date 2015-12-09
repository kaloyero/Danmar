package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.danmar.mapper.Mapper;
import com.danmar.service.BaseService;
import com.facturador.danmar.manager.GenericManager;
import com.facturador.danmar.service.GenericService;

public abstract class GenericManagerImpl<F> implements GenericManager<F>, BaseService {

	protected abstract GenericService getService() ;
	protected abstract Mapper getMapper() ;

	@Override
	@Transactional
	public ErrorRespuestaBean save(F form) {
		ErrorRespuestaBean rta = new ErrorRespuestaBean(true);
		getService().save(getMapper().getEntidad(form));
		
		return rta;
	}

	@Override
	public List<F> getAll() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public F findById(int id) {
		return (F) getMapper().getForm(getService().findById(id));
	}
	

}