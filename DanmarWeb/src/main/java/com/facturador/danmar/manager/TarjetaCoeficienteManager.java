package com.facturador.danmar.manager;

import java.util.List;

import com.facturador.danmar.form.TarjetaForm;

public interface TarjetaCoeficienteManager {
	
	List<TarjetaForm> getAll(); 
	
	TarjetaForm getById(int tarjeta,int cuotas);

	public List<TarjetaForm> getCuotas(int tarjeta);
}
