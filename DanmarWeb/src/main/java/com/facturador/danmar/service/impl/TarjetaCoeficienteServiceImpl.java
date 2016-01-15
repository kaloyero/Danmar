package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.dao.TarjetaCoeficienteDao;
import com.facturador.danmar.model.TarjetaCoeficiente;
import com.facturador.danmar.service.TarjetaCoeficienteService;

@Service("tarjetaCoeficienteService")
public class TarjetaCoeficienteServiceImpl extends GenericServiceImpl<TarjetaCoeficiente> 
			implements TarjetaCoeficienteService {
	
	@Autowired
	private TarjetaCoeficienteDao tarjetaCoeficienteDao;

	@Override
	protected GenericDao<TarjetaCoeficiente> getDao() {
		return tarjetaCoeficienteDao;
	}

	public List<TarjetaCoeficiente> getAll() {
		return tarjetaCoeficienteDao.getAll();
	}   

	public List<TarjetaCoeficiente> getCuotasByTarjeta(int tarjeta) {
		return tarjetaCoeficienteDao.getAllByTarjeta(tarjeta);
	}   

	
	public TarjetaCoeficiente getById(int tarjeta,int cuotas) {
		TarjetaCoeficiente dto = tarjetaCoeficienteDao.getById(tarjeta, cuotas);
		return dto;
	}	
}