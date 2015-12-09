package com.facturador.danmar.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.danmar.mapper.Mapper;
import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.form.DocumentoLineaForm;
import com.facturador.danmar.form.DocumentoPagoForm;
import com.facturador.danmar.form.mapper.DocumentoEncabezadoMapper;
import com.facturador.danmar.manager.DocumentoEncabezadoManager;
import com.facturador.danmar.manager.DocumentoLineaManager;
import com.facturador.danmar.manager.DocumentoPagoManager;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.service.DocumentoEncabezadoService;
import com.facturador.danmar.service.GenericService;

@Service("documentoEncabezadoManager")
public class DocumentoEncabezadoManagerImpl extends GenericManagerImpl<DocumentoEncabezadoForm>
			implements DocumentoEncabezadoManager {

	@Autowired
	private DocumentoEncabezadoService documentoEncabezadoService;

	@Autowired
	private DocumentoLineaManager documentoLineaManager;

	@Autowired
	private DocumentoPagoManager documentoPagoManager;

	@Override
	protected GenericService<DocumentoEncabezado> getService() {
		return documentoEncabezadoService;
	}

	@Override
	protected Mapper<DocumentoEncabezado, DocumentoEncabezadoForm> getMapper() {
		return new DocumentoEncabezadoMapper();
	}

	@Transactional()
	@Override
	public ErrorRespuestaBean save(DocumentoEncabezadoForm form) {
		DocumentoEncabezado ent = new DocumentoEncabezado();

		// Seteo la fecha actual
		Date fechaActual = new Date();
		ent.setFecha(fechaActual);
		ent.setFechaActualiza(fechaActual);
		ent.setFechaCreacion(fechaActual);

		//Estado VIGENTE
		ent.setEstadoId(1);
		
		// Pongo el usuario logueado
		ent.setUsuarioActualizaId(1);
		ent.setUsuarioCreadorId(1);
		
		//Pongo la Sucursal
		ent.setSucursalId(1);
		
		//Busco el numero nuevo 
		// @Todo
		ent.setNumero(132);
		
		//Tipo Factura (FAC)
		ent.setTipoDocumentoId(1);

		//Letra
		ent.setLetra(form.getLetra());
		
		//Nro cliente
		ent.setClienteNro(ConvertionUtil.IntValueOf(form.getClienteNro()));
		
		getService().save(ent);
		
		for (DocumentoLineaForm linea : form.getLineas()) {
			linea.setEncabezadoId(1);
			documentoLineaManager.save(linea);
		}
		for (DocumentoPagoForm pago : form.getPagos()) {
			pago.setDocumentoEncabezado(1);
			documentoPagoManager.save(pago);
		}		
		
		return new ErrorRespuestaBean(true);

	}

}
