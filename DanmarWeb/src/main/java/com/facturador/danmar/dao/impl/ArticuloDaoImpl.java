package com.facturador.danmar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.ArticuloDao;
import com.facturador.danmar.model.Articulo;

@Repository("articuloDao")
public class ArticuloDaoImpl implements ArticuloDao {

	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Articulo ent){
		this.sessionFactory.getCurrentSession().save(ent);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Articulo> getAll(){
		Criteria ct = this.sessionFactory.getCurrentSession().createCriteria(Articulo.class);
		ct.setFirstResult(90000);
		ct.setMaxResults(50);
		ct.addOrder(Order.asc("articulo"));
		
		
		
		return ct.list();
	}



}
