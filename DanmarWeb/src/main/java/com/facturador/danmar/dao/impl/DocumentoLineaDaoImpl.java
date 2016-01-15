package com.facturador.danmar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.DocumentoLineaDao;
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.model.DocumentoLinea_V;

@Repository("documentoLineaDao")
public class DocumentoLineaDaoImpl extends GenericDaoImpl<DocumentoLinea> implements DocumentoLineaDao{
	@Override
	protected Class<DocumentoLinea> getEntityClass() {
		return DocumentoLinea.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DocumentoLinea_V> getLineasViewByIdEncabezado(int id) {
		Criteria ct = getSession().createCriteria(DocumentoLinea_V.class); 
		ct.add(Restrictions.eq("documentoEncabezadoId", id));
		
		return ct.list();
	}
}
