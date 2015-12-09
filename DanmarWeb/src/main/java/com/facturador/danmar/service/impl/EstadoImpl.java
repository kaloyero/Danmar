package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.EstadoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.Estados;
import com.facturador.danmar.service.EstadoService;

@Service("estadoService")
public class EstadoImpl extends GenericServiceImpl<Estados> 
			implements EstadoService {
	
	@Autowired
	private EstadoDao estadoDao;

	@Override
	protected GenericDao<Estados> getDao() {
		return estadoDao;
	}



}