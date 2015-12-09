package com.facturador.danmar.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.mapper.ArticuloMapper;
import com.facturador.danmar.manager.ArticuloManager;
import com.facturador.danmar.model.Articulo;
import com.facturador.danmar.service.ArticuloService;

@Service("articuloManager")
public class ArticuloManagerImpl implements ArticuloManager{

	@Autowired
	private ArticuloService articuloService;
	
	protected ArticuloMapper getMapper(){
		return new ArticuloMapper();
	}

	public ArticuloForm getById(String articulo) {
		return null;
	}

	public List<ArticuloForm> getAll(FiltroArticulo filtro) {
		List<Articulo> lista = articuloService.getAllFilter(filtro);
		return getMapper().getFormList(lista);
	}   
	
}
