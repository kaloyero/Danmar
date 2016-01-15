package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.DocumentoLineaDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.model.DocumentoLinea_V;
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

	@Override
	@Transactional
	public List<DocumentoLinea_V> getLineasViewByIdEncabezado(int id) {
		return documentoLineaDao.getLineasViewByIdEncabezado(id);
	}



}