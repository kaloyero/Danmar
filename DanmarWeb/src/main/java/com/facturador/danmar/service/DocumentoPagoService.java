package com.facturador.danmar.service;

import java.util.List;

import com.facturador.danmar.model.DocumentoPago;


public interface DocumentoPagoService extends GenericService<DocumentoPago> {

	List<DocumentoPago> getPagosByDocEncabezadoId(int docEncabezadoId) ;
}
