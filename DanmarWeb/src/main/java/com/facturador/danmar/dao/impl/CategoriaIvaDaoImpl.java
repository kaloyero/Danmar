package com.facturador.danmar.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.CategoriaIvaDao;
import com.facturador.danmar.model.CategoriaIva;

@Repository("categoriaIvaDao")
public class CategoriaIvaDaoImpl extends GenericDaoImpl<CategoriaIva> implements CategoriaIvaDao{

	@Override
	protected Class<CategoriaIva> getEntityClass() {
		return CategoriaIva.class;
	}

	@Transactional
	@Override
	public CategoriaIva findById(int id){
		Criteria ct = getSession().createCriteria(getEntityClass()); 
		ct.add(Restrictions.eq("categoria", id));
		
		return (CategoriaIva) ct.uniqueResult();
	}
	
}
