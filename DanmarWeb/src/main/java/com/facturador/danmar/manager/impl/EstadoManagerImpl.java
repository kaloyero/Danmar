package com.facturador.danmar.manager.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.EstadosForm;
import com.facturador.danmar.form.mapper.EstadoMapper;
import com.facturador.danmar.manager.EstadoManager;
import com.facturador.danmar.model.Estados;
import com.facturador.danmar.service.EstadoService;
import com.facturador.danmar.service.GenericService;

@Service("estadoManager")
public class EstadoManagerImpl extends GenericManagerImpl<EstadosForm> 
			implements EstadoManager {
	
	@Autowired
	private EstadoService EstadoService;

	@Override
	protected GenericService<Estados> getService() {
		return EstadoService;
	}
	@Override
	protected Mapper<Estados,EstadosForm> getMapper() {
		return new EstadoMapper();
	}




}