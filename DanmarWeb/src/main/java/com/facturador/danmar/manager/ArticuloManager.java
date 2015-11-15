package com.facturador.danmar.manager;

import com.facturador.danmar.form.ArticuloForm;

public interface ArticuloManager extends PaginacionManager<ArticuloForm> {

	public ArticuloForm getById(String articulo);   
}   
	    
