package com.facturador.danmar.service;

import java.util.List;

import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.model.DocumentoLinea_V;


public interface DocumentoLineaService extends GenericService<DocumentoLinea> {

	public List<DocumentoLinea_V> getLineasViewByIdEncabezado(int id);
}
