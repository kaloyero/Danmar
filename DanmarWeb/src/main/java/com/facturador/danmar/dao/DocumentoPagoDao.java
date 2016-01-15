package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.model.DocumentoPago;

public interface DocumentoPagoDao extends GenericDao<DocumentoPago>{

	public List<DocumentoPago> getPagosByDocEncabezadoId(int documentoEncabezadoId);
}