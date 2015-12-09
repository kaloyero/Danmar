package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.DocumentoImpuestoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoImpuesto;
import com.facturador.danmar.service.DocumentoImpuestoService;

@Service("documentoImpuestoService")
public class DocumentoImpuestoServiceImpl extends GenericServiceImpl<DocumentoImpuesto> 
			implements DocumentoImpuestoService {
	
	@Autowired
	private DocumentoImpuestoDao documentoImpuestoDao;

	@Override
	protected GenericDao<DocumentoImpuesto> getDao() {
		return documentoImpuestoDao;
	}



}