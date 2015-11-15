package com.danmar.dbf.service;

import java.util.List;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.service.PaginacionService;

public interface ArticuloService extends PaginacionService<ArticuloDto>{

	public ArticuloDto getById(String articulo);
		
	public  List<ArticuloDto> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros);

}
