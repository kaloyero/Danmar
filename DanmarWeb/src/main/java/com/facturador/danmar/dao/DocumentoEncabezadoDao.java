package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.model.DocumentoEncabezado_V;

public interface DocumentoEncabezadoDao extends GenericDao<DocumentoEncabezado> {

	public int getUltimaFactura(String letra);
	
	public DocumentoEncabezado_V getFacturaViewById(int id);
	
	public List<DocumentoEncabezado_V> getFacturaAllView(FiltroFactura filtro);
	
}