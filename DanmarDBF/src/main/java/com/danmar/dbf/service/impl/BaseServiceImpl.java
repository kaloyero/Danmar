package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dbf.dao.impl.ArticuloDao;
import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.dbf.service.ArticuloService;

public class BaseServiceImpl extends PaginacionServiceImpl<ArticuloDto> implements ArticuloService{

    
	ArticuloDao dao = new ArticuloDao();

	protected ArticuloDao getDao() {
		return dao;
	}   
	
	public ArticuloDto getById(String articulo) {
		return dao.getById(articulo);
	}   
	    
	public  List<ArticuloDto> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros) {
		return dao.searchByFiltros(filtro,pagina,cantRegistros);
	}

	    
	
	
}
