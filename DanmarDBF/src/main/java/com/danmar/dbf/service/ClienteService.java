package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.danmar.service.PaginacionService;

public interface ClienteService extends PaginacionService<ClienteDto>{

	List<ClienteDto> getAll(); 

	public ClienteDto getById(int numero);
	
	public  List<ClienteDto> searchByFiltros(FiltroCliente filtro) ;
}
