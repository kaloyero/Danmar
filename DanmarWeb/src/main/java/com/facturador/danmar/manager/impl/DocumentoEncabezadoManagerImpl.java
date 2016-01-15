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
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.service.DocumentoEncabezadoService;
import com.facturador.danmar.service.GenericService;
import com.facturador.danmar.util.CalculosUtil;

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
		return null;
	}
	
	@Transactional()
	@Override
	public String saveDoc(DocumentoEncabezadoForm form) {
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
		
		//Tipo Factura (FAC)
		ent.setTipoDocumentoId(1);

		//Letra
		ent.setLetra(form.getLetra());

		//Busco el numero nuevo 
		int ultimaNumeroFactura = documentoEncabezadoService.getUltimaFactura(ent.getLetra());
		int nuevoNumeroFactura =  ultimaNumeroFactura + 1;
		ent.setNumero(nuevoNumeroFactura);
		
		//Nro cliente
		if (ConvertionUtil.IntValueOf(form.getClienteNro()) != null && ConvertionUtil.IntValueOf(form.getClienteNro()) >= 1){
			ent.setClienteNro(ConvertionUtil.IntValueOf(form.getClienteNro()));
		}
		
		//Guardo el encabezado
		getService().save(ent);

		//Guardo los pagos que se realizarón para la factura
//		Double coeficioenteInteresTc = 0.00;
//		Double totalAbonadoTc = 0.00;
		for (DocumentoPagoForm pago : form.getPagos()) {
			pago.setDocumentoEncabezado(ent.getId());
			//En el caso de que sea tarjeta de credito voy a necesitar los valores para calcular por producto
//			if (pago.getTipoPago().equals("TC")) {
//				coeficioenteInteresTc = ConvertionUtil.DouValueOf(pago.getCoeficiente());
//				totalAbonadoTc = ConvertionUtil.DouValueOf( pago.getImporte() );
//			}
			documentoPagoManager.save(pago);
		}		
		
		//Guardo las líneas de la factura generada
		for (DocumentoLineaForm linea : form.getLineas()) {
			linea.setEncabezadoId(ent.getId());
			documentoLineaManager.save(linea);
		}

		
		
		String nuevaFactura = ent.getLetra() + ent.getNumero();
		
		return nuevaFactura ;

	}
	
}
