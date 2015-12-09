package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.model.DocumentoEncabezado;

@Repository("documentoEncabezadoDao")
public class DocumentoEncabezadoDaoImpl extends GenericDaoImpl<DocumentoEncabezado> implements DocumentoEncabezadoDao{
	@Override
	protected Class<DocumentoEncabezado> getEntityClass() {
		return DocumentoEncabezado.class;
	}
}
