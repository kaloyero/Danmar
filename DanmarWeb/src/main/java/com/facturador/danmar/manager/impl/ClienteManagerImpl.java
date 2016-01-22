package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.mapper.ClienteMapper;
import com.facturador.danmar.manager.ClienteManager;
import com.facturador.danmar.model.Cliente;
import com.facturador.danmar.service.ClienteService;

@Service("clienteManager")
public class ClienteManagerImpl implements ClienteManager{

	@Autowired
	ClienteService clienteService;
	
	protected ClienteService getService(){
		return clienteService;
	}

	protected ClienteMapper getMapper(){
		return new ClienteMapper();
	}

	@Override
	public ClienteForm getById(int numero) {
		return getMapper().getForm(clienteService.findById(numero));
	}

	@Override
	public List<ClienteForm> getAll(FiltroCliente filtro) {
		
		
		List<Cliente> lista = clienteService.searchByFiltros(filtro);
		return getMapper().getFormList(lista);
	}

	@Override
	public void updateClientesDBF(){
		//Obtengo los clientes DBF
		ClienteDto[] clientesDbf = getService().getAllClientesDbf();
		//los mapeo a Cliente
		List<Cliente> clientes = getService().mapperDtoToModel(clientesDbf);
		//Los inserto en la base local
		getService().insertList(clientes);
	}

	
}
