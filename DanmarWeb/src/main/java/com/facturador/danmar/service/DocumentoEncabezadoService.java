package com.facturador.danmar.service;

import com.facturador.danmar.model.DocumentoEncabezado;


public interface DocumentoEncabezadoService extends GenericService<DocumentoEncabezado> {

	public int getUltimaFactura (String letra);
	
}
