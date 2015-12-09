package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.DocumentoTipoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoTipo;
import com.facturador.danmar.service.DocumentoTipoService;

@Service("documentoTipoService")
public class DocumentoTipoServiceImpl extends GenericServiceImpl<DocumentoTipo> 
			implements DocumentoTipoService {
	
	@Autowired
	private DocumentoTipoDao documentoTipoDao;

	@Override
	protected GenericDao<DocumentoTipo> getDao() {
		return documentoTipoDao;
	}



}