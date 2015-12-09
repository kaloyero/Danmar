package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoLineaDao;
import com.facturador.danmar.model.DocumentoLinea;

@Repository("documentoLineaDao")
public class DocumentoLineaDaoImpl extends GenericDaoImpl<DocumentoLinea> implements DocumentoLineaDao{
	@Override
	protected Class<DocumentoLinea> getEntityClass() {
		return DocumentoLinea.class;
	}
}
