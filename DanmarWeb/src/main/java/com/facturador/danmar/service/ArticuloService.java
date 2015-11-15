package com.facturador.danmar.service;

import java.util.List;

import com.danmar.error.ErrorRespuestaBean;
import com.danmar.service.BaseService;
import com.facturador.danmar.model.Articulo;


public interface ArticuloService extends BaseService {

	ErrorRespuestaBean save(Articulo dto);
	
	List <Articulo> getAll(int pagina,int cantidadRegistros);
}
