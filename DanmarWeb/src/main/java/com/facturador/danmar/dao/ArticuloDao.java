package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.model.Articulo;

public interface ArticuloDao {

	public void save(Articulo ent);

	public List<Articulo > getAll();

}