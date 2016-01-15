package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.model.DocumentoLinea_V;

public interface DocumentoLineaDao extends GenericDao<DocumentoLinea>{

	public List<DocumentoLinea_V> getLineasViewByIdEncabezado(int id);
}