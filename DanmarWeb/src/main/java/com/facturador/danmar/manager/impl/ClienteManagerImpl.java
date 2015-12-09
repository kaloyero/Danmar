package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.danmar.dbf.service.ClienteService;
import com.danmar.dbf.service.impl.ClienteServiceImpl;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.mapper.ClienteMapper;
import com.facturador.danmar.manager.ClienteManager;

@Service("clienteManager")
public class ClienteManagerImpl implements ClienteManager{

	ClienteService clienteService = new ClienteServiceImpl();
	
	protected ClienteService getService(){
		return new ClienteServiceImpl();
	}

	protected ClienteMapper getMapper(){
		return new ClienteMapper();
	}

	@Override
	public ClienteForm getById(int numero) {
		return getMapper().getForm(clienteService.getById(numero));
	}

	@Override
	public List<ClienteForm> getAll(FiltroCliente filtro) {
		List<ClienteDto> lista = clienteService.searchByFiltros(filtro);
		return getMapper().getFormList(lista);
	}


	
}
