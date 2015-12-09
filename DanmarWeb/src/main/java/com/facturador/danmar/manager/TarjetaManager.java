package com.facturador.danmar.manager;

import java.util.List;

import com.facturador.danmar.form.TarjetaForm;

public interface TarjetaManager {

	List<TarjetaForm> getAll(int pagina, int cantRegistros);
	
	List<TarjetaForm> getAll(); 
	
	TarjetaForm getById(int tarjeta,int cuotas);

	public List<TarjetaForm> getCuotas(int tarjeta);
}
