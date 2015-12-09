package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.TarjetaDto;

public interface TarjetaService {

	List<TarjetaDto> getAll(int pagina, int cantRegistros);
	
	List<TarjetaDto> getAll(); 
	
	TarjetaDto getById(int tarjeta,int cuotas);
	
	public List<TarjetaDto> getCuotasByTarjeta(int tarjeta);
}
