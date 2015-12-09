package com.facturador.danmar.dao.impl;

import org.springframework.stereotype.Repository;

import com.facturador.danmar.dao.PagoTipoDao;
import com.facturador.danmar.model.PagoTipo;

@Repository("pagoTipoDao")
public class PagoTipoDaoImpl extends GenericDaoImpl<PagoTipo>  implements PagoTipoDao{
	@Override
	protected Class<PagoTipo> getEntityClass() {
		return PagoTipo.class;
	}
}
