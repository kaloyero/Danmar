package com.facturador.danmar.manager;

import com.facturador.danmar.form.ClienteForm;

public interface ClienteManager extends PaginacionManager<ClienteForm> {

	ClienteForm getById(int numero);
}
