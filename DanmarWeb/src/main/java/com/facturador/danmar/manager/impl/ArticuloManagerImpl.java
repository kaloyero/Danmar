package com.facturador.danmar.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.mapper.ArticuloMapper;
import com.facturador.danmar.manager.ArticuloManager;
import com.facturador.danmar.model.Articulo;
import com.facturador.danmar.service.ArticuloService;
import com.facturador.danmar.service.impl.ArticuloServiceImpl;

@Service("articuloManager")
public class ArticuloManagerImpl extends BaseManagerImpl<Articulo, ArticuloForm> implements ArticuloManager{

	@Autowired
	private ArticuloService articuloService;
	
	
	protected ArticuloService getService(){
		return new ArticuloServiceImpl();
	}

	protected ArticuloMapper getMapper(){
		return new ArticuloMapper();
	}

	public ArticuloForm getById(String articulo) {
		return null;
		//return getMapper().getForm(getService().getById(articulo));
	}

	
}
