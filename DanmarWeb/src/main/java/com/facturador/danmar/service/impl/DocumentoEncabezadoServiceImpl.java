package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.service.DocumentoEncabezadoService;

@Service("documentoEncabezadoService")
public class DocumentoEncabezadoServiceImpl extends GenericServiceImpl<DocumentoEncabezado> 
			implements DocumentoEncabezadoService {
	
	@Autowired
	private DocumentoEncabezadoDao documentoEncabezadoDao;

	@Override
	protected GenericDao<DocumentoEncabezado> getDao() {
		return documentoEncabezadoDao;
	}

	@Override
	public int getUltimaFactura(String letra) {
		int ultimaFactura = documentoEncabezadoDao.getUltimaFactura(letra);
		
		return ultimaFactura;
	}


}