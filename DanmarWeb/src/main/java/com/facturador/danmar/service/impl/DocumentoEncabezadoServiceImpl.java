package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.model.DocumentoEncabezado_V;
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

	@Override
	@Transactional
	public DocumentoEncabezado_V getFacturaViewById(int id) {
		
		return documentoEncabezadoDao.getFacturaViewById(id);
	}

	@Override
	@Transactional
	public List<DocumentoEncabezado_V> getFacturaViewAll(FiltroFactura filtro) {
		return documentoEncabezadoDao.getFacturaAllView(filtro);
	}
}