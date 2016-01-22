package com.facturador.danmar.dao;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.model.Cliente;

public interface ClienteDao extends GenericDao<Cliente> {
	
	public List<Cliente> searchByFiltros(FiltroCliente filtro);
	
	
}