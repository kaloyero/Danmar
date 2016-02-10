package com.facturador.danmar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.filtro.Paginacion;
import com.facturador.danmar.dao.ArticuloDao;
import com.facturador.danmar.model.Articulo;

@Repository("articuloDao")
public class ArticuloDaoImpl extends GenericDaoImpl<Articulo> implements ArticuloDao {

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Articulo> getAll(){
		Criteria ct = getSession().createCriteria(Articulo.class);
		ct.setFirstResult(90000);
		ct.setMaxResults(50);
		ct.addOrder(Order.asc("articulo"));
		
		return ct.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Articulo> getAllFilterPaging(FiltroArticulo filtro){
		Criteria ct = getSession().createCriteria(Articulo.class);
		ct.setFirstResult( (filtro.getPagina() -1 ) * filtro.getCantRegistros());
		ct.setMaxResults(filtro.getCantRegistros());
		ct.addOrder(Order.asc("articulo"));
		setFiltros(ct, filtro);
		
		
		
		return ct.list();
	}
	
	protected void setFiltros (Criteria ct, FiltroArticulo filtro){
		
		if (filtro.getArticulo() != null && ( ! filtro.getArticulo().trim().equals(""))){
			ct.add(Restrictions.like("articulo", filtro.getArticulo() + "%"));
		}
		if (filtro.getCc1() != null && ( ! filtro.getCc1().trim().equals(""))){
			ct.add(Restrictions.like("cc1", filtro.getCc1() + "%"));
		}
		if (filtro.getCc2() != null && ( ! filtro.getCc2().trim().equals(""))){
			ct.add(Restrictions.like("cc2", filtro.getCc2() + "%"));
		}
		if (filtro.getCc3() != null && ( ! filtro.getCc3().trim().equals(""))){
			ct.add(Restrictions.like("cc3", filtro.getCc3() + "%"));
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Articulo> getAllPaging(Paginacion pag){
		Criteria ct = getSession().createCriteria(Articulo.class);
		ct.setFirstResult( (pag.getPagina() -1 ) * pag.getCantRegistros());
		ct.setMaxResults(pag.getCantRegistros());
		ct.addOrder(Order.asc("articulo"));
		
		return ct.list();
	}

	@Override
	protected Class<Articulo> getEntityClass() {
		return Articulo.class;
	}

	
}
