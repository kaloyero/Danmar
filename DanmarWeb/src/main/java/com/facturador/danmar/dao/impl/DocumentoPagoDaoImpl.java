package com.facturador.danmar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.DocumentoPagoDao;
import com.facturador.danmar.model.DocumentoPago;

@Repository("documentoPagoDao")
public class DocumentoPagoDaoImpl extends GenericDaoImpl<DocumentoPago> implements DocumentoPagoDao{
	@Override
	protected Class<DocumentoPago> getEntityClass() {
		return DocumentoPago.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DocumentoPago> getPagosByDocEncabezadoId(int documentoEncabezadoId) {
		Criteria ct = getSession().createCriteria(DocumentoPago.class);
		ct.add(Restrictions.like("documentoEncabezado", documentoEncabezadoId));
		
		return ct.list();
	}
}
