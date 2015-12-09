package com.facturador.danmar.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.DocumentoImpuestoForm;
import com.facturador.danmar.form.mapper.DocumentoImpuestoMapper;
import com.facturador.danmar.manager.DocumentoImpuestoManager;
import com.facturador.danmar.model.DocumentoImpuesto;
import com.facturador.danmar.service.DocumentoImpuestoService;
import com.facturador.danmar.service.GenericService;

@Service("documentoImpuestoManager")
public class DocumentoImpuestoManagerImpl extends GenericManagerImpl<DocumentoImpuestoForm>
		implements DocumentoImpuestoManager {

	@Autowired
	private DocumentoImpuestoService DocumentoImpuestoService;

	@Override
	protected GenericService<DocumentoImpuesto> getService() {
		return DocumentoImpuestoService;
	}

	@Override
	protected Mapper<DocumentoImpuesto, DocumentoImpuestoForm> getMapper() {
		return new DocumentoImpuestoMapper();
	}

}