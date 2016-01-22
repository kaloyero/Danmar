package com.facturador.danmar.service;

import java.util.List;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.model.Cliente;


public interface ClienteService extends GenericService<Cliente> {
	
	
	public  List<Cliente> searchByFiltros(FiltroCliente filtro) ;

	public ClienteDto[] getAllClientesDbf();

	public List<Cliente> mapperDtoToModel ( ClienteDto[] clientesDto);
	
	public void insertList ( List<Cliente> clientes);
	
}
