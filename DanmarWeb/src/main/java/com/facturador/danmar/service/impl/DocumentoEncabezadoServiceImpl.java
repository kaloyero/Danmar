package com.facturador.danmar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.facturador.danmar.dao.DocumentoEncabezadoDao;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.service.DocumentoEncabezadoService;

@Service("documentoEncabezadoService")
public class DocumentoEncabezadoServiceImpl implements DocumentoEncabezadoService {

	
	@Autowired
	private DocumentoEncabezadoDao documentoEncabezadoDao;

	@Transactional(readOnly=true)
	public ErrorRespuestaBean save(DocumentoEncabezado dto) {
		documentoEncabezadoDao.save(dto);
		return new ErrorRespuestaBean(true);
	}

	


}