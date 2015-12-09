package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.impl.TarjetaDao;
import com.danmar.dbf.dto.TarjetaDto;
import com.danmar.dbf.service.TarjetaService;

public class TarjetaServiceImpl implements TarjetaService{

    
	TarjetaDao dao = new TarjetaDao();
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	public List<TarjetaDto> getAll(int pagina, int cantRegistros) {
		return dao.getAll(pagina, cantRegistros);
	}   

	public List<TarjetaDto> getAll() {
		return dao.getAll();
	}   

	public List<TarjetaDto> getCuotasByTarjeta(int tarjeta) {
		return dao.getAllByTarjeta(tarjeta);
	}   

	
	public TarjetaDto getById(int tarjeta,int cuotas) {
		TarjetaDto dto = dao.getById(tarjeta, cuotas);

		return dto;
	}	
}
