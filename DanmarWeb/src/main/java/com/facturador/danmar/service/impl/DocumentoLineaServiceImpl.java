package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.DocumentoLineaDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.service.DocumentoLineaService;

@Service("documentoLineaService")
public class DocumentoLineaServiceImpl extends GenericServiceImpl<DocumentoLinea> 
			implements DocumentoLineaService {
	
	@Autowired
	private DocumentoLineaDao documentoLineaDao;

	@Override
	protected GenericDao<DocumentoLinea> getDao() {
		return documentoLineaDao;
	}



}