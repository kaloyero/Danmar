package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.form.mapper.TarjetaMapper;
import com.facturador.danmar.manager.TarjetaManager;
import com.facturador.danmar.service.TarjetaService;

@Service("tarjetaManager")
public class TarjetaManagerImpl extends GenericManagerImpl<TarjetaForm> implements TarjetaManager{

	@Autowired
	TarjetaService tarjetaService;
	
	protected TarjetaService getService(){
		return tarjetaService;
	}

	protected TarjetaMapper getMapper(){
		return new TarjetaMapper();
	}
	
	@Override
	public List<TarjetaForm> getAll() {
		return getMapper().getFormList(getService().getAll());
	}   
	
}
