package com.facturador.danmar.service;

import java.util.List;

import com.facturador.danmar.model.TarjetaCoeficiente;


public interface TarjetaCoeficienteService extends GenericService<TarjetaCoeficiente> {

	List<TarjetaCoeficiente> getAll(); 
	
	TarjetaCoeficiente getById(int tarjeta,int cuotas);
	
	public List<TarjetaCoeficiente> getCuotasByTarjeta(int tarjeta);
}
