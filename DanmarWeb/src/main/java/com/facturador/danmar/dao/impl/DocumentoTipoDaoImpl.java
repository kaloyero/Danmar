package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoTipoDao;
import com.facturador.danmar.model.DocumentoTipo;

@Repository("documentoTipoDao")
public class DocumentoTipoDaoImpl extends GenericDaoImpl<DocumentoTipo> implements DocumentoTipoDao{
	@Override
	protected Class<DocumentoTipo> getEntityClass() {
		return DocumentoTipo.class;
	}
}
