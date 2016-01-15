package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.form.mapper.TarjetaCoeficienteMapper;
import com.facturador.danmar.manager.TarjetaCoeficienteManager;
import com.facturador.danmar.service.TarjetaCoeficienteService;

@Service("tarjetaCoeficienteManager")
public class TarjetaCoeficienteManagerImpl implements TarjetaCoeficienteManager{

	@Autowired
	TarjetaCoeficienteService tarjetaCoeficienteService;
	
	protected TarjetaCoeficienteService getService(){
		return tarjetaCoeficienteService;
	}

	protected TarjetaCoeficienteMapper getMapper(){
		return new TarjetaCoeficienteMapper();
	}

	public List<TarjetaForm> getAll() {
		return getMapper().getFormList(getService().getAll());
	}   

	public List<TarjetaForm> getCuotas(int tarjeta) {
		return getMapper().getFormList(getService().getCuotasByTarjeta(tarjeta));
	}   
	
	public TarjetaForm getById(int tarjeta,int cuotas) {
		return getMapper().getForm(getService().getById(tarjeta,cuotas));
	}  
}
