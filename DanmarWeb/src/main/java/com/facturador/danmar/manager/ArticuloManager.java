package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;

public interface ArticuloManager {

	public ArticuloForm getById(String articulo);   
	
	public List<ArticuloForm> getAll(FiltroArticulo pag);

	void updateArticuloDBF();
}   
	    
