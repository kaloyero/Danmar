package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.TarjetaDao;
import com.facturador.danmar.model.Tarjeta;

@Repository("tarjetaDao")
public class TarjetaDaoImpl extends GenericDaoImpl<Tarjeta> implements TarjetaDao{
	@Override
	protected Class<Tarjeta> getEntityClass() {
		return Tarjeta.class;
	}
}
