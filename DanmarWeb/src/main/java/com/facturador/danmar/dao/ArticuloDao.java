package com.facturador.danmar.dao;

import java.util.List;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.filtro.Paginacion;
import com.facturador.danmar.model.Articulo;

public interface ArticuloDao extends GenericDao<Articulo>{

	public void save(Articulo ent);
	
	public void saveOrUpdate(Articulo ent);

	public List<Articulo > getAll();
	
	public List<Articulo> getAllPaging(Paginacion pag);
	
	public List<Articulo> getAllFilterPaging(FiltroArticulo pag);

}