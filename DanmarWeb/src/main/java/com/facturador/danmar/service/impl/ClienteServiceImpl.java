package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.dao.ClienteDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.Cliente;
import com.facturador.danmar.service.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl extends GenericServiceImpl<Cliente> 
			implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	protected GenericDao<Cliente> getDao() {
		return clienteDao;
	}

	@Override
	public List<Cliente> searchByFiltros(FiltroCliente filtro) {
		return clienteDao.searchByFiltros(filtro);
	}


}