package com.facturador.danmar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.TarjetaCoeficienteDao;
import com.facturador.danmar.model.TarjetaCoeficiente;

@Repository("tarjetaCoeficienteDao")
public class TarjetaCoeficienteDaoImpl extends
		GenericDaoImpl<TarjetaCoeficiente> implements TarjetaCoeficienteDao {
	@Override
	protected Class<TarjetaCoeficiente> getEntityClass() {
		return TarjetaCoeficiente.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<TarjetaCoeficiente> getAllByTarjeta(int tarjeta) {
		Criteria ct = getSession().createCriteria(getEntityClass());
		ct.add(Restrictions.eq("tarjetaCuota.tarjetaId", tarjeta));
		ct.addOrder(Order.asc("tarjetaCuota.cuotas"));

		List<TarjetaCoeficiente> list = ct.list();

		return list;
	}

	@Transactional
	public TarjetaCoeficiente getById(int tarjeta, int cuotas) {

		Criteria ct = getSession().createCriteria(getEntityClass());
		ct.add(Restrictions.eq("tarjetaCuota.tarjetaId", tarjeta));
		ct.add(Restrictions.eq("tarjetaCuota.cuotas", cuotas));

		TarjetaCoeficiente res = (TarjetaCoeficiente) ct.uniqueResult();

		return res;
	}
}
