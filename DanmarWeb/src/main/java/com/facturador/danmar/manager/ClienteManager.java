package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.DocumentoEncabezadoForm;

public interface ClienteManager {

	ClienteForm getById(int numero);
	
	public List<ClienteForm> getAll(FiltroCliente filtro);

		
}
