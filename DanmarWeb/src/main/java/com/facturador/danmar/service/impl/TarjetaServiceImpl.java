package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.dao.TarjetaDao;
import com.facturador.danmar.model.Tarjeta;
import com.facturador.danmar.service.TarjetaService;

@Service("tarjetaService")
public class TarjetaServiceImpl extends GenericServiceImpl<Tarjeta> 
			implements TarjetaService {
	
	@Autowired
	private TarjetaDao tarjetaDao;

	@Override
	protected GenericDao<Tarjeta> getDao() {
		return tarjetaDao;
	}


}