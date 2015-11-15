package com.danmar.service;

import java.util.List;

import com.danmar.filtro.Paginacion;

public interface PaginacionService <E> extends BaseService{
	
	/**
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	List<E> getAll(Paginacion paginacion);
}
