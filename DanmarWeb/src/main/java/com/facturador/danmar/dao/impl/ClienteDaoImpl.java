package com.facturador.danmar.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.dao.ClienteDao;
import com.facturador.danmar.model.Cliente;

@Repository("clienteDao")
public class ClienteDaoImpl extends GenericDaoImpl<Cliente> implements ClienteDao{
	@Override
	protected Class<Cliente> getEntityClass() {
		return Cliente.class;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cliente> searchByFiltros(FiltroCliente filtro) {
		Criteria ct = getSession().createCriteria(Cliente.class);
//		ct.setFirstResult( (filtro.getPagina() -1 ) * filtro.getCantRegistros());
//		ct.setMaxResults(filtro.getCantRegistros());
		ct.addOrder(Order.asc("nombre"));
		setFiltros(ct, filtro);
		
		return ct.list();
	}
	
	protected void setFiltros (Criteria ct, FiltroCliente filtro){
		
		if (filtro.getCodigo() > 0){
			ct.add(Restrictions.eq("id", filtro.getCodigo() ));
		}
		if (StringUtils.isNotEmpty(filtro.getCuit())){
			ct.add(Restrictions.like("cuit", filtro.getCuit() + "%"));
		}
		if (StringUtils.isNotEmpty(filtro.getRazonSocial())){
			ct.add(Restrictions.like("razonSocial", filtro.getRazonSocial() + "%"));
		}
		if (StringUtils.isNotEmpty(filtro.getTipo())){
			ct.add(Restrictions.like("tipoCliente", filtro.getTipo() + "%"));
		}
		if (StringUtils.isNotEmpty(filtro.getNombre())){
			ct.add(Restrictions.like("nombre", filtro.getNombre() + "%"));
		}		
	}

	@Override
	@Transactional
	public int getAllFilterPagingCount(FiltroCliente filtro) {
		Criteria ct = getSession().createCriteria(Cliente.class);
		setFiltros(ct, filtro);

		Integer res = ((Number) ct.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		
		return res.intValue() ;
	}


	
}
