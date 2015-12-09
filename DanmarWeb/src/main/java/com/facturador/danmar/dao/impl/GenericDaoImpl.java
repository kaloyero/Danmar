package com.facturador.danmar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.GenericDao;

public abstract class GenericDaoImpl<E> implements GenericDao<E> {

	@Autowired
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	protected abstract Class<E> getEntityClass ();
	
	@Transactional
	public void save(E ent){
		getSession().save(ent);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> getAll(){
		Criteria ct = getSession().createCriteria(getEntityClass()); 
		
		return ct.list();
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public E findById(int id){
		Criteria ct = getSession().createCriteria(getEntityClass()); 
		ct.add(Restrictions.eq("id", id));
		
		return (E) ct.uniqueResult();
	}

}
