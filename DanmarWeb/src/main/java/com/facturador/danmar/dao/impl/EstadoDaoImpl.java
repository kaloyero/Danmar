package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.EstadoDao;
import com.facturador.danmar.model.Estados;

@Repository("estadoDao")
public class EstadoDaoImpl extends GenericDaoImpl<Estados> implements EstadoDao{
	@Override
	protected Class<Estados> getEntityClass() {
		return Estados.class;
	}
}
