package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.CategoriaIvaDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.CategoriaIva;
import com.facturador.danmar.service.CategoriaIvaService;

@Service("categoriaIvaService")
public class CategoriaIvaServiceImpl extends GenericServiceImpl<CategoriaIva> 
			implements CategoriaIvaService {
	
	@Autowired
	private CategoriaIvaDao categoriaIvaDao;

	@Override
	protected GenericDao<CategoriaIva> getDao() {
		return categoriaIvaDao;
	}
	
	

}