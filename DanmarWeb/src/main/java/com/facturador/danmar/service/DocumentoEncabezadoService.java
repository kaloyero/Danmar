package com.facturador.danmar.service;

import java.util.List;

import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.model.DocumentoEncabezado_V;


public interface DocumentoEncabezadoService extends GenericService<DocumentoEncabezado> {

	public int getUltimaFactura (String letra);
	
	public DocumentoEncabezado_V getFacturaViewById(int id);

	List<DocumentoEncabezado_V> getFacturaViewAll(FiltroFactura filtro);
}
