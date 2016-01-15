package com.facturador.danmar.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.DateUtil;
import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.model.DocumentoEncabezado_V;

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

	@Override
	@Transactional
	public DocumentoEncabezado_V getFacturaViewById(int id) {
		Criteria ct = getSession().createCriteria(DocumentoEncabezado_V.class); 
		ct.add(Restrictions.eq("id", id));
		
		return (DocumentoEncabezado_V) ct.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DocumentoEncabezado_V> getFacturaAllView(FiltroFactura filtro) {
		Criteria ct = getSession().createCriteria(DocumentoEncabezado_V.class); 
		
		ct.setFirstResult( (filtro.getPagina() -1 ) * filtro.getCantRegistros());
		ct.setMaxResults(filtro.getCantRegistros());
		if (StringUtils.isBlank(filtro.getOrderBy()) ){
			ct.addOrder(Order.asc("fecha"));	
		} else {
			ct.addOrder(Order.asc(filtro.getOrderBy()));
		}
		
		setFiltros(ct, filtro);
		
		return ct.list();
	}
	
	protected void setFiltros (Criteria ct, FiltroFactura filtro){
		
		if (StringUtils.isNotBlank(filtro.getCodigoFactura() ) ){
			ct.add(Restrictions.eq("id", ConvertionUtil.IntValueOf(filtro.getCodigoFactura()) ));
		}
		if (StringUtils.isNotBlank(filtro.getNumeroFactura() ) ){
			ct.add(Restrictions.like("facturaNumero", filtro.getNumeroFactura() + "%"));
		}
		if (StringUtils.isNotBlank(filtro.getFechaDesde()) ){
			ct.add(Restrictions.ge("fecha", DateUtil.convertStringToDate(filtro.getFechaDesde(),"yyyy-MM-dd") ));
		}
		if (StringUtils.isNotBlank(filtro.getFechaHasta()) ){
			ct.add(Restrictions.le("fecha", DateUtil.convertStringToDate(filtro.getFechaHasta(),"yyyy-MM-dd") ));
		}

	}

}
