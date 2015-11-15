package com.facturador.danmar.manager;

import java.util.List;

import com.danmar.filtro.Paginacion;
import com.danmar.manager.BaseManager;

public interface PaginacionManager<E> extends BaseManager{

	public List<E> getAll(Paginacion paginacion);

	public  List<E> searchByCampo(Paginacion paginacion);
	
	public  List<E> searchByFiltros(Paginacion filtro);
	
}   
	    
