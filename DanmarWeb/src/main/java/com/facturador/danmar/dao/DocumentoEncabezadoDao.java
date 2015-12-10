package com.facturador.danmar.dao;

import com.facturador.danmar.model.DocumentoEncabezado;

public interface DocumentoEncabezadoDao extends GenericDao<DocumentoEncabezado> {

	public int getUltimaFactura(String letra);
	
	
}