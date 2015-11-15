package com.facturador.danmar.manager.impl;

import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.service.ClienteService;
import com.danmar.dbf.service.impl.ClienteServiceImpl;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.mapper.ClienteMapper;
import com.facturador.danmar.manager.ClienteManager;

@Service("clienteManager")
public class ClienteManagerImpl extends BaseManagerImpl<ClienteDto, ClienteForm> implements ClienteManager{

	protected ClienteService getService(){
		return new ClienteServiceImpl();
	}

	protected ClienteMapper getMapper(){
		return new ClienteMapper();
	}

	@Override
	public ClienteForm getById(int numero) {
		return null;
	}
	



	
	
}
