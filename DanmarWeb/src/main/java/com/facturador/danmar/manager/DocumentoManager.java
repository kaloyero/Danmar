package com.facturador.danmar.manager;

import java.util.List;

import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.form.DocumentoEncabezadoForm;


public interface DocumentoManager  {

	DocumentoEncabezadoForm getFacturaById(int idFactura);
	
	public List<DocumentoEncabezadoForm> getFacturaAll(FiltroFactura filtro) ;
	
}
