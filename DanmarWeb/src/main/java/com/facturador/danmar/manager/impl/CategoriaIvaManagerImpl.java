package com.facturador.danmar.manager.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.CategoriaIvaForm;
import com.facturador.danmar.form.mapper.CategoriaIvaMapper;
import com.facturador.danmar.manager.CategoriaIvaManager;
import com.facturador.danmar.model.CategoriaIva;
import com.facturador.danmar.service.CategoriaIvaService;
import com.facturador.danmar.service.GenericService;

@Service("categoriaIvaManager")
public class CategoriaIvaManagerImpl extends GenericManagerImpl<CategoriaIvaForm> 
			implements CategoriaIvaManager {
	
	@Autowired
	private CategoriaIvaService categoriaIvaService;

	@Override
	protected GenericService<CategoriaIva> getService() {
		return categoriaIvaService;
	}

	@Override
	protected Mapper getMapper() {
		return new CategoriaIvaMapper();
	}



}