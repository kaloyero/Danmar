package com.facturador.danmar.manager.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.PagoTipoForm;
import com.facturador.danmar.form.mapper.PagoTipoMapper;
import com.facturador.danmar.manager.PagoTipoManager;
import com.facturador.danmar.model.PagoTipo;
import com.facturador.danmar.service.GenericService;
import com.facturador.danmar.service.PagoTipoService;

@Service("pagoTipoManager")
public class PagoTipoManagerImpl extends GenericManagerImpl<PagoTipoForm> 
			implements PagoTipoManager {
	
	@Autowired
	private PagoTipoService pagoTipoService;

	@Override
	protected GenericService<PagoTipo> getService() {
		return pagoTipoService;
	}
	@Override
	protected Mapper<PagoTipo,PagoTipoForm> getMapper() {
		return new PagoTipoMapper();
	}




}