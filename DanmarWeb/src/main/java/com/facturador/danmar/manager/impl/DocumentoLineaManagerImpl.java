package com.facturador.danmar.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.DocumentoLineaForm;
import com.facturador.danmar.form.mapper.DocumentoLineaMapper;
import com.facturador.danmar.manager.DocumentoLineaManager;
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.service.DocumentoLineaService;
import com.facturador.danmar.service.GenericService;

@Service("documentoLineaManager")
public class DocumentoLineaManagerImpl extends
		GenericManagerImpl<DocumentoLineaForm> implements DocumentoLineaManager {

	@Autowired
	private DocumentoLineaService DocumentoLineaService;

	@Override
	protected GenericService<DocumentoLinea> getService() {
		return DocumentoLineaService;
	}

	@Override
	protected Mapper<DocumentoLinea, DocumentoLineaForm> getMapper() {
		return new DocumentoLineaMapper();
	}


}