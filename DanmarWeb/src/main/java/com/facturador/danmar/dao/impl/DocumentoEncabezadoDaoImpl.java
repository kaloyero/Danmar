package com.facturador.danmar.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.model.DocumentoEncabezado;

@Repository("documentoEncabezadoDao")
public class DocumentoEncabezadoDaoImpl extends GenericDaoImpl<DocumentoEncabezado> implements DocumentoEncabezadoDao{
	@Override
	protected Class<DocumentoEncabezado> getEntityClass() {
		return DocumentoEncabezado.class;
	}

	@Override
	public int getUltimaFactura(String letra) {
		DocumentoEncabezado res = new DocumentoEncabezado();
		int ultimaFactura = 0;
		Criteria ct = getSession().createCriteria(DocumentoEncabezado.class);
		ct.add(Restrictions.like("letra", letra ));
		ct.setMaxResults(1);
		ct.addOrder(Order.desc("numero"));
		res= (DocumentoEncabezado) ct.uniqueResult();
		if (res != null){
			ultimaFactura = res.getNumero();
		}
		
		
		return ultimaFactura;
	}
}
