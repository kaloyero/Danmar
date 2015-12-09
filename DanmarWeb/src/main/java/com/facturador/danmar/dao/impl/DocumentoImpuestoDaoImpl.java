package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoImpuestoDao;
import com.facturador.danmar.model.DocumentoImpuesto;

@Repository("documentoImpuestoDao")
public class DocumentoImpuestoDaoImpl extends GenericDaoImpl<DocumentoImpuesto> implements DocumentoImpuestoDao{
	@Override
	protected Class<DocumentoImpuesto> getEntityClass() {
		return DocumentoImpuesto.class;
	}
}
