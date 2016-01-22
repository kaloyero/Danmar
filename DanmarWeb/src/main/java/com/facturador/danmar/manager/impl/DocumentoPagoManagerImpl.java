package com.facturador.danmar.manager.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.error.ErrorRespuestaBean;
import com.danmar.mapper.Mapper;
import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.form.DocumentoPagoForm;
import com.facturador.danmar.form.mapper.DocumentoPagoMapper;
import com.facturador.danmar.manager.DocumentoPagoManager;
import com.facturador.danmar.model.DocumentoPago;
import com.facturador.danmar.service.DocumentoPagoService;
import com.facturador.danmar.service.GenericService;

@Service("documentoPagoManager")
public class DocumentoPagoManagerImpl extends GenericManagerImpl<DocumentoPagoForm>implements DocumentoPagoManager {

	
	
	
	@Autowired
	private DocumentoPagoService documentoPagoService;

	@Override
	protected GenericService<DocumentoPago> getService() {
		return documentoPagoService;
	}

	@Override
	protected Mapper<DocumentoPago, DocumentoPagoForm> getMapper() {
		return new DocumentoPagoMapper();
	}

	@Transactional()
	@Override
	public ErrorRespuestaBean save(DocumentoPagoForm form) {
		DocumentoPago pago = new DocumentoPago();

		pago.setDocumentoEncabezado(form.getDocumentoEncabezado());
		pago.setImporte(ConvertionUtil.DouValueOf(form.getImporte()));

		if (form.getTipoPago().equals("EF")) {
			pago.setTipoPago(1);
		} else {
			if (StringUtils.isNotBlank(form.getCoeficiente()))
				pago.setCoeficiente(ConvertionUtil.DouValueOf(form.getCoeficiente()));
			if (StringUtils.isNotBlank(form.getCupon()))
				pago.setNroCupon(form.getCupon());
			if (StringUtils.isNotBlank(form.getTarjeta()))
				pago.setTarjeta(ConvertionUtil.IntValueOf(form.getTarjeta()));

			if (form.getTipoPago().equals("TC")) {
				// TARJETA CREDITO
				pago.setCoefRecargoTC(ConvertionUtil.DouValueOf(form.getCoefRecargoTC()));
				pago.setCuotas(ConvertionUtil.IntValueOf(form.getCuotas()));
				pago.setTipoPago(2);
			} else if (form.getTipoPago().equals("TD")) {
				// TARJETA DEBITO
				pago.setTipoPago(3);
			}

		}
		documentoPagoService.save(pago);

		return new ErrorRespuestaBean(false);

	}


}