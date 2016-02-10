package com.facturador.danmar.service;

import java.util.List;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.error.ErrorRespuestaBean;
import com.danmar.filtro.Paginacion;
import com.facturador.danmar.model.Articulo;


public interface ArticuloService extends  GenericService<Articulo> {

	public List <Articulo> getAll(Paginacion paginacion);
	
	public List<Articulo> getAllFilter(FiltroArticulo filtro);
	
	public ArticuloDto[] getAllArticulosDbf();

	void insertList(List<Articulo> articulosDbf);

	List<Articulo> mapperDtoToModel(ArticuloDto[] articulosDbf);
}
