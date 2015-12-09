package com.facturador.danmar.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.danmar.service.BaseService;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.service.GenericService;

public abstract class GenericServiceImpl<E> implements GenericService<E>, BaseService {

	@SuppressWarnings("rawtypes")
	protected abstract GenericDao getDao() ;

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public ErrorRespuestaBean save(E dto) {
		ErrorRespuestaBean rta = new ErrorRespuestaBean(true);
		getDao().save(dto);
		
		return rta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		return getDao().getAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E findById(int id) {
		return (E) getDao().findById(id);
	}
	
	

}
