package com.danmar.dbf.rest;

import java.util.List;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.TarjetaDto;

/**
 * Servicios
 * 
 * @author Alejandro Masciotra
 *
 */

public interface ConsultasService {

	public List<ArticuloDto> getArticulos();

	public List<ClienteDto> getClientes();
	
	public List<TarjetaDto> getTArjetaAlicuota();
	
	/**
	 * Servicio de prueba
	 * 
	 * @return mensaje de prueba
	 */
	public String getTest();
}