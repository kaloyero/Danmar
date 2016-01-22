package com.facturador.danmar.service;

import java.util.List;

import com.danmar.dbf.dto.TarjetaDto;
import com.facturador.danmar.model.TarjetaCoeficiente;


public interface TarjetaCoeficienteService extends GenericService<TarjetaCoeficiente> {

	List<TarjetaCoeficiente> getAll(); 
	
	TarjetaCoeficiente getById(int tarjeta,int cuotas);
	
	public List<TarjetaCoeficiente> getCuotasByTarjeta(int tarjeta);

	TarjetaDto[] getAllTarjetaCoefDbf();

	List<TarjetaCoeficiente> mapperDtoToModel(TarjetaDto[] tarjetaDbf);

	void insertList(List<TarjetaCoeficiente> tarjetaCoef);
}
