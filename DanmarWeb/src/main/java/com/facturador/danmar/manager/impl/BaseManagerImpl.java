package com.facturador.danmar.manager.impl;

import java.util.List;

import com.danmar.dbf.service.impl.PaginacionServiceImpl;
import com.danmar.filtro.Paginacion;
import com.danmar.mapper.Mapper;
import com.danmar.service.BaseService;

public abstract class BaseManagerImpl<E,F> {
	
		BaseService service = getService();

		protected abstract BaseService getService();

		protected abstract Mapper<E, F> getMapper();

		@SuppressWarnings("unchecked")
		public List<F> getAll(Paginacion pag) {
			
			PaginacionServiceImpl<E> paginacionServiceImpl = (PaginacionServiceImpl<E>) service;
			List<E> lista = paginacionServiceImpl.getAll(pag);
			
			return getMapper().getFormList(lista);
		}   

		public  List<F> searchByCampo(Paginacion paginacion){
			return null;
		}
		
		public  List<F> searchByFiltros(Paginacion filtro){
			return null;
		}

		
//		@SuppressWarnings("unchecked")
//		public List<F> filterByCampo(Paginacion pag) {
//			
//			PaginacionServiceImpl<E> paginacionServiceImpl = (PaginacionServiceImpl<E>) service;
//			List<E> lista = paginacionServiceImpl.getAll(pag);
//			
//			return getMapper().getFormList(lista);
//		}   
//		
//		public List<F> searchByFiltro() {
//			getService().searchByFiltros(filtro,pagina,cantRegistros)
//			return getMapper().getFormList();
//		}  
}
