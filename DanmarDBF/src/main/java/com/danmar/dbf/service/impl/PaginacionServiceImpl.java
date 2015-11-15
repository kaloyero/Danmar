package com.danmar.dbf.service.impl;

import java.util.List;

import com.danmar.dao.PaginacionDao;
import com.danmar.filtro.Paginacion;
import com.danmar.service.PaginacionService;

public abstract class PaginacionServiceImpl<E> implements PaginacionService<E>{

	protected abstract PaginacionDao<E> getDao();
	
	public List<E> getAll(Paginacion pag) {
		return getDao().getAll(pag.getPagina(), pag.getCantRegistros());
	}   

//	public List<E> searchByCampo(Paginacion pag) {
//		return getDao().
//	}   
//
//	public abstract List<E> searchByCampo(F filtro) ;
}
