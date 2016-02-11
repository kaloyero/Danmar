package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.form.ClienteForm;

public interface ClienteManager {

	ClienteForm getById(int numero);
	
	public List<ClienteForm> getAll(FiltroCliente filtro);

	void updateClientesDBF();

	public int getAllCount(FiltroCliente filtro);

		
}
