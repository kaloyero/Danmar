package com.facturador.danmar.service;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.error.ErrorRespuestaBean;
import com.danmar.filtro.Paginacion;
import com.danmar.service.BaseService;
import com.facturador.danmar.model.Articulo;


public interface ArticuloService extends BaseService {

	ErrorRespuestaBean save(Articulo dto);
	
	public List <Articulo> getAll(Paginacion paginacion);
	
	public List<Articulo> getAllFilter(FiltroArticulo filtro);
}
