package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.dao.PagoTipoDao;
import com.facturador.danmar.model.PagoTipo;
import com.facturador.danmar.service.PagoTipoService;

@Service("pagoTipoService")
public class PagoTipoServiceImpl extends GenericServiceImpl<PagoTipo> 
			implements PagoTipoService {
	
	@Autowired
	private PagoTipoDao pagoTipoDao;

	@Override
	protected GenericDao<PagoTipo> getDao() {
		return pagoTipoDao;
	}



}