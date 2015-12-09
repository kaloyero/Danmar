package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.DocumentoPagoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoPago;
import com.facturador.danmar.service.DocumentoPagoService;

@Service("documentoPagoService")
public class DocumentoPagoServiceImpl extends GenericServiceImpl<DocumentoPago> 
			implements DocumentoPagoService {
	
	@Autowired
	private DocumentoPagoDao documentoPagoDao;

	@Override
	protected GenericDao<DocumentoPago> getDao() {
		return documentoPagoDao;
	}



}