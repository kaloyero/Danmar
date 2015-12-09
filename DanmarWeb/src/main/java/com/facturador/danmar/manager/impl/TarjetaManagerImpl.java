package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danmar.dbf.service.TarjetaService;
import com.danmar.dbf.service.impl.TarjetaServiceImpl;
import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.form.mapper.TarjetaMapper;
import com.facturador.danmar.manager.TarjetaManager;

@Service("tarjetaService")
public class TarjetaManagerImpl implements TarjetaManager{

	protected TarjetaService getService(){
		return new TarjetaServiceImpl();
	}

	protected TarjetaMapper getMapper(){
		return new TarjetaMapper();
	}
	
	public List<TarjetaForm> getAll(int pagina, int cantRegistros) {
		return getMapper().getFormList(getService().getAll(pagina, cantRegistros));
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
