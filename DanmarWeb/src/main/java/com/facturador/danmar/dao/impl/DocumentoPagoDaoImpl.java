package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoPagoDao;
import com.facturador.danmar.model.DocumentoPago;

@Repository("documentoPagoDao")
public class DocumentoPagoDaoImpl extends GenericDaoImpl<DocumentoPago> implements DocumentoPagoDao{
	@Override
	protected Class<DocumentoPago> getEntityClass() {
		return DocumentoPago.class;
	}
}
