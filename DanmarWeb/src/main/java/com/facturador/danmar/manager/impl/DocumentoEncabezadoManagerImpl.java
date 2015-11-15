package com.facturador.danmar.manager.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.form.mapper.DocumentoEncabezadoMapper;
import com.facturador.danmar.manager.DocumentoEncabezadoManager;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.service.DocumentoEncabezadoService;

@Service("documentoEncabezadoManager")
public class DocumentoEncabezadoManagerImpl implements DocumentoEncabezadoManager {

	
	protected DocumentoEncabezadoMapper getMapper(){
		return new DocumentoEncabezadoMapper();
	}
	
	@Autowired
	private DocumentoEncabezadoService documentoEncabezadoService;

	@Transactional()
	public ErrorRespuestaBean save(DocumentoEncabezadoForm form) {
		DocumentoEncabezado ent = new DocumentoEncabezado();
		
		//Seteo la fecha actual
		Date fechaActual = new Date();
		ent.setFecha(fechaActual);
		ent.setFechaActualiza(fechaActual);
		ent.setFechaCreacion(fechaActual);
		
		//Pongo el usuario logueado
		ent.setUsuarioActualizaId(1);
		ent.setUsuarioCreadorId(1);
		
		return documentoEncabezadoService.save(ent);
		
	}

	


}